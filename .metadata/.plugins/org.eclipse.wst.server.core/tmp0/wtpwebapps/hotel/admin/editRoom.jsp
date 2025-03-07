 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.mysql.cj.jdbc.Driver" errorPage="error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!
    PreparedStatement pst;
    ResultSet rs;
%>

<%
    // Déclaration de la variable pour la connexion
    Connection conn = null;

    try {
        // Informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/hotel_management";  
        String user = "root";  
        String password = "triki";  

        // Charger le driver JDBC pour MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Établir la connexion
        conn = DriverManager.getConnection(url, user, password);
        
        // Vérifier si la connexion a échoué
        if (conn == null) {
            out.println("<script>alert('Database connection error!'); window.location.href='error.jsp';</script>");
            return;
        }
    } catch (SQLException | ClassNotFoundException e) {
        // Afficher les erreurs dans la console et rediriger en cas d'échec
        e.printStackTrace();
        out.println("<script>alert('Error connecting to the database!'); window.location.href='error.jsp';</script>");
        return;
    }

    // Variables pour l'édition du type de chambre
    String id = request.getParameter("id");
    String label = "";
    int capacity = 0;
    int price = 0;

    // Récupérer les détails du type de chambre si l'ID est présent
    try {
        if (id != null) {
            String sql = "SELECT * FROM RoomType WHERE id = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(id));
            rs = pst.executeQuery();

            if (rs.next()) {
                label = rs.getString("label");
                capacity = rs.getInt("capacity");
                price = rs.getInt("price");
            } else {
                out.println("<script>alert('No room found with the given ID!'); window.location.href='error.jsp';</script>");
                return;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("<script>alert('Error retrieving room data!'); window.location.href='error.jsp';</script>");
        return;
    }

    // Mise à jour des informations du type de chambre
    if (request.getParameter("update") != null) {
        try {
            label = request.getParameter("label");
            capacity = Integer.parseInt(request.getParameter("capacity"));
            price = Integer.parseInt(request.getParameter("price"));

            // Validation des entrées
            if (label == null || label.isEmpty() || capacity <= 0 || price <= 0) {
                out.println("<script>alert('Invalid input data!'); window.location.href='error.jsp';</script>");
                return;
            }

            String updateSql = "UPDATE RoomType SET label = ?, capacity = ?, price = ? WHERE id = ?";
            pst = conn.prepareStatement(updateSql);
            pst.setString(1, label);
            pst.setInt(2, capacity);
            pst.setInt(3, price);
            pst.setInt(4, Integer.parseInt(id));

            // Exécution de la mise à jour
            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                out.println("<script>alert('Room details updated successfully!'); window.location.href='profit.jsp';</script>");
            } else {
                out.println("<script>alert('Failed to update room details!'); window.location.href='error.jsp';</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<script>alert('Error updating room details!'); window.location.href='error.jsp';</script>");
        }
    }
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Edit Room - Hotel Management</title>
    
    <!-- CSS intégré pour la mise en page -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            padding: 20px;
        }
        .form-container {
            background-color: white;
            border-radius: 5px;
            padding: 30px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: auto;
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-container label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        .form-container input, .form-container button {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .form-container button {
            background-color: #2196F3;
            color: white;
            cursor: pointer;
            font-weight: bold;
        }
        .form-container button:hover {
            background-color: #0b7dda;
        }
        .form-container input:focus, .form-container button:focus {
            outline: none;
            border-color: #2196F3;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Edit Room</h2>
        <form method="post" action="editRoom.jsp?id=<%= id %>">
            <label for="label">Room Type:</label>
            <input type="text" id="label" name="label" value="<%= label %>" required />

            <label for="capacity">Capacity:</label>
            <input type="number" id="capacity" name="capacity" value="<%= capacity %>" required min="1" />

            <label for="price">Price:</label>
            <input type="number" id="price" name="price" value="<%= price %>" required min="1" />

            <button type="submit" name="update">Update Room</button>
        </form>
    </div>
</body>
</html>

 