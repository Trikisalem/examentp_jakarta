<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Room</title>
</head>
<body>
    <h1>Delete Room</h1>
    
    <%
        String roomId = request.getParameter("id");
        if (roomId != null) {
            String url = "jdbc:mysql://localhost:3306/hotel"; // Modifiez selon votre base
            String user = "root"; // Modifiez avec vos informations
            String password = "triki"; // Modifiez avec votre mot de passe
            
            Connection conn = null;
            PreparedStatement ps = null;
            
            try {
                // Établir la connexion
                conn = DriverManager.getConnection(url, user, password);
                
                String sql = "DELETE FROM RoomType WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(roomId));
                
                int rowsAffected = ps.executeUpdate();
                
                if (rowsAffected > 0) {
                    out.println("<h2>Room deleted successfully!</h2>");
                } else {
                    out.println("<h2>Room not found!</h2>");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    %>
</body>
</html>
