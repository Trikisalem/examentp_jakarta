<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Hotel</title>
</head>
<body>

<h1>Add New Hotel</h1>

<%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String starsStr = request.getParameter("stars");
        String description = request.getParameter("description");
        String image = request.getParameter("image");

        // Validation des données
        if (idStr == null || idStr.trim().isEmpty()) {
            out.println("<p>Error: Hotel ID is required.</p>");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            int stars = Integer.parseInt(starsStr);

            // Connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/hotel_management";
            String user = "root";
            String password = "triki";
            Connection conn = null;
            PreparedStatement stmt = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);

                String insertQuery = "INSERT INTO Hotel (id, name, city, stars, description, image) VALUES (?, ?, ?, ?, ?, ?)";
                stmt = conn.prepareStatement(insertQuery);
                stmt.setInt(1, id);
                stmt.setString(2, name);
                stmt.setString(3, city);
                stmt.setInt(4, stars);
                stmt.setString(5, description);
                stmt.setString(6, image);

                int result = stmt.executeUpdate();
                if (result > 0) {
                    out.println("<p>Hotel added successfully!</p>");
                } else {
                    out.println("<p>Error adding hotel.</p>");
                }

            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p>Error: " + e.getMessage() + "</p>");
            } finally {
                if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
                if (conn != null) try { conn.close(); } catch (SQLException e) {}
            }
        } catch (NumberFormatException e) {
            out.println("<p>Error: Invalid number format for ID or Stars.</p>");
        }
    }
%>

<!-- Formulaire d'ajout d'hôtel -->
<form method="post" action="addHotel.jsp">
    <input type="number" name="id" placeholder="Hotel ID" required />
    <input type="text" name="name" placeholder="Hotel Name" required />
    <input type="text" name="city" placeholder="City" required />
    <input type="number" name="stars" placeholder="Stars" required />
    <textarea name="description" placeholder="Description" required></textarea>
    <input type="text" name="image" placeholder="Image URL" required />
    <button type="submit">Add Hotel</button>
</form>

</body>
</html>
