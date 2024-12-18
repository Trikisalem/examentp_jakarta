<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Hotel</title>
    <script>
        function showAlert(message, isSuccess) {
            alert(message);
            if (isSuccess) {
                window.location.href = "hotel.jsp"; // Redirige vers hotel.jsp après succès
            }
        }
    </script>
</head>
<body>

<%
    // Vérifier si l'ID est présent dans les paramètres de la requête
    String hotelId = request.getParameter("id");

    if (hotelId == null || hotelId.isEmpty()) {
        out.println("<script>showAlert('Error: Hotel ID is required.', false);</script>");
    } else {
        // Récupérer les informations soumises par le formulaire
        int id = Integer.parseInt(hotelId);
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        int stars = Integer.parseInt(request.getParameter("stars"));
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        int agentId = Integer.parseInt(request.getParameter("agentId"));

        // Connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/hotel_management";
        String user = "root";
        String password = "triki";

        Connection conn = null;
        PreparedStatement stmt = null;

        // Mettre à jour les informations de l'hôtel dans la base de données
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            String sql = "UPDATE Hotel SET name = ?, city = ?, stars = ?, description = ?, image = ?, agentId = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, name);
            stmt.setString(2, city);
            stmt.setInt(3, stars);
            stmt.setString(4, description);
            stmt.setString(5, image);
            stmt.setInt(6, agentId);
            stmt.setInt(7, id);

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                out.println("<script>showAlert('Hotel updated successfully!', true);</script>");
            } else {
                out.println("<script>showAlert('Hotel update failed. Please try again.', false);</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script>showAlert('Error: " + e.getMessage() + "', false);</script>");
        } finally {
            if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
            if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
        }
    }
%>

</body>
</html>
