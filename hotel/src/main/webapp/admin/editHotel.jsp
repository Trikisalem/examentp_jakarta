<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Hotel</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        form {
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input, textarea, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #2196F3;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0b7dda;
        }
    </style>
</head>
<body>

<%
    // Étape 1 : Récupérer l'ID de l'hôtel à éditer
    int id = Integer.parseInt(request.getParameter("id"));

    // Variables pour stocker les informations existantes
    String name = "";
    String city = "";
    int stars = 0;
    String description = "";
    String image = "";
    int agentId = 0;

    // Connexion à la base de données
    String url = "jdbc:mysql://localhost:3306/hotel_management";
    String user = "root";
    String password = "triki";

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    // Charger les informations actuelles de l'hôtel
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);

        // Vérifier si la colonne 'agentId' existe dans la table Hotel
        DatabaseMetaData meta = conn.getMetaData();
        ResultSet columns = meta.getColumns(null, null, "Hotel", "agentId");
        if (!columns.next()) {
            // Si la colonne n'existe pas, l'ajouter
            String alterTableQuery = "ALTER TABLE Hotel ADD COLUMN agentId INT";
            stmt = conn.prepareStatement(alterTableQuery);
            stmt.executeUpdate();
        }

        // Charger les données de l'hôtel à partir de la base
        String sql = "SELECT * FROM Hotel WHERE id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        if (rs.next()) {
            name = rs.getString("name");
            city = rs.getString("city");
            stars = rs.getInt("stars");
            description = rs.getString("description");
            image = rs.getString("image");
            agentId = rs.getInt("agentId");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
    }
%>

<!-- Formulaire d'édition -->
<h2>Edit Hotel</h2>
<form action="updateHotel.jsp" method="post">
    <input type="hidden" name="id" value="<%= id %>">

    <label for="name">Hotel Name:</label>
    <input type="text" id="name" name="name" value="<%= name %>" required>

    <label for="city">City:</label>
    <input type="text" id="city" name="city" value="<%= city %>" required>

    <label for="stars">Stars:</label>
    <select id="stars" name="stars" required>
        <option value="1" <%= (stars == 1 ? "selected" : "") %>>1 Star</option>
        <option value="2" <%= (stars == 2 ? "selected" : "") %>>2 Stars</option>
        <option value="3" <%= (stars == 3 ? "selected" : "") %>>3 Stars</option>
        <option value="4" <%= (stars == 4 ? "selected" : "") %>>4 Stars</option>
        <option value="5" <%= (stars == 5 ? "selected" : "") %>>5 Stars</option>
    </select>

    <label for="description">Description:</label>
    <textarea id="description" name="description" rows="5" required><%= description %></textarea>

    <label for="image">Image URL:</label>
    <input type="text" id="image" name="image" value="<%= image %>">

    <label for="agentId">Agent ID:</label>
    <input type="number" id="agentId" name="agentId" value="<%= agentId %>" required>

    <button type="submit">Update Hotel</button>
</form>

<%
    // Étape 2 : Traitement du formulaire lors de la soumission
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        // Récupérer les valeurs soumises
        String newName = request.getParameter("name");
        String newCity = request.getParameter("city");
        int newStars = Integer.parseInt(request.getParameter("stars"));
        String newDescription = request.getParameter("description");
        String newImage = request.getParameter("image");
        int newAgentId = Integer.parseInt(request.getParameter("agentId"));

        // Mettre à jour l'hôtel dans la base de données
        try {
            String updateSql = "UPDATE Hotel SET name = ?, city = ?, stars = ?, description = ?, image = ?, agentId = ? WHERE id = ?";
            stmt = conn.prepareStatement(updateSql);

            stmt.setString(1, newName);
            stmt.setString(2, newCity);
            stmt.setInt(3, newStars);
            stmt.setString(4, newDescription);
            stmt.setString(5, newImage);
            stmt.setInt(6, newAgentId);
            stmt.setInt(7, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                out.println("<p>Hotel updated successfully!</p>");
            } else {
                out.println("<p>Failed to update hotel.</p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } finally {
            if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
            if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
        }
    }
%>

</body>
</html>
