<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Hotel</title>
    <script>
        function showAlert(message, isSuccess) {
            alert(message);
            if (isSuccess) {
                window.location.href = "hotel.jsp"; // Redirige vers hotel.jsp après suppression
            }
        }
    </script>
</head>
<body>

<%
    // Vérifier si l'ID de l'hôtel est passé dans les paramètres de la requête
    String hotelId = request.getParameter("id");

    if (hotelId == null || hotelId.isEmpty()) {
        out.println("<script>showAlert('Error: Hotel ID is required.', false);</script>");
    } else {
        // Récupérer l'ID de l'hôtel à supprimer
        int id = Integer.parseInt(hotelId);

        // Connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/hotel_management";
        String user = "root";
        String password = "triki";

        Connection conn = null;
        PreparedStatement stmt = null;

        // Suppression de l'hôtel dans la base de données
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            String sql = "DELETE FROM Hotel WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                out.println("<script>showAlert('Hotel deleted successfully!', true);</script>");
            } else {
                out.println("<script>showAlert('Hotel deletion failed. Please try again.', false);</script>");
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
