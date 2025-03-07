<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Room</title>
</head>
<body>
    <h1>Edit Room</h1>
    
    <%
        String roomId = request.getParameter("id");
        
        if (roomId != null && !roomId.trim().isEmpty()) {
            String url = "jdbc:mysql://localhost:3306/hotel"; // Modifiez selon votre base
            String user = "root"; // Modifiez avec vos informations
            String password = "triki"; // Modifiez avec votre mot de passe
            
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            try {
                // Charger le driver JDBC (si nécessaire, selon la version de JDBC)
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Établir la connexion
                conn = DriverManager.getConnection(url, user, password);
                
                // Préparer la requête SQL
                String sql = "SELECT * FROM RoomType WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(roomId));
                
                // Exécuter la requête
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    String label = rs.getString("label");
                    int capacity = rs.getInt("capacity");
                    double price = rs.getDouble("price");
    %>
    <form action="updateRoom.jsp" method="post">
        <input type="hidden" name="id" value="<%= roomId %>" />
        <label>Room Type:</label>
        <input type="text" name="label" value="<%= label %>" required /><br />
        
        <label>Capacity:</label>
        <input type="number" name="capacity" value="<%= capacity %>" required /><br />
        
        <label>Price:</label>
        <input type="number" name="price" value="<%= price %>" required /><br />
        
        <input type="submit" value="Update Room" />
    </form>
    <%
                } else {
                    out.println("<p>No room found with ID: " + roomId + "</p>");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                out.println("<p>Error: " + e.getMessage() + "</p>");
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            out.println("<p>Invalid room ID.</p>");
        }
    %>
</body>
</html>
