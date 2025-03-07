<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Room Management</title>
    <style>
        /* Global Styles */
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #e1f5fe; /* Bleu ciel pour le fond */
            display: flex;
            justify-content: center; /* Center the form horizontally */
            align-items: center;
            height: 100vh;
            margin: 0;
            padding: 0;
            color: #333;
        }

        h1 {
            font-size: 2.5rem;
            color: #212121;
            text-align: center;
            margin-bottom: 30px;
            font-weight: 600;
            letter-spacing: 1px;
        }

        /* Form Container Styling */
        .form-container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 480px;
            text-align: center;
            transition: box-shadow 0.3s ease, transform 0.3s ease;
            border: 1px solid #e0e0e0;
        }

        .form-container:hover {
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.15);
            transform: scale(1.03);
        }

        .form-container h3 {
            font-size: 1.6rem;
            color: #4f4f4f;
            margin-bottom: 20px;
            font-weight: 500;
        }

        /* Input Fields */
        .form-container input,
        .form-container select,
        .form-container textarea {
            width: 100%;
            padding: 14px;
            margin: 10px 0;
            background-color: #f9fafb;
            border: 1px solid #e0e0e0;
            border-radius: 8px;
            font-size: 1rem;
            color: #212121;
            transition: border 0.3s ease, box-shadow 0.3s ease;
        }

        .form-container input:focus,
        .form-container textarea:focus {
            outline: none;
            border-color: #4CAF50;
            box-shadow: 0 0 8px rgba(76, 175, 80, 0.4);
        }

        /* Button Styles */
        .form-container button {
            width: 100%;
            padding: 14px;
            background-color: #4fc3f7; /* Bleu ciel pour le bouton */
            color: #ffffff;
            border: none;
            border-radius: 8px;
            font-size: 1.1rem;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.3s ease;
            margin-top: 20px;
        }

        .form-container button:hover {
            background-color: #29b6f6; /* Un bleu un peu plus foncé pour l'effet hover */
            transform: translateY(-2px);
        }

        .form-container button:active {
            background-color: #0288d1; /* Un bleu encore plus foncé quand le bouton est actif */
            transform: translateY(2px);
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .form-container {
                padding: 25px;
                margin: 20px;
                width: 90%;
                margin-left: 0;
            }

            h1 {
                font-size: 2rem;
            }

            .form-container h3 {
                font-size: 1.4rem;
            }
        }
    </style>
</head>
<body>

<!-- Formulaire pour ajouter une chambre -->
<div class="form-container">
    <form method="post" action="addRoom.jsp">
        <h3>Add a New Room</h3>
        <input type="number" name="id" placeholder="Room ID" required>
        <input type="text" name="label" placeholder="Room Label" required>
        <input type="number" name="capacity" placeholder="Room Capacity" required>
        <input type="number" name="price" placeholder="Room Price" required>
        
        <button type="submit">Add Room</button>
    </form>
    <button class="back-button" onclick="window.location.href='hotel.jsp';">Retour</button>
    
</div>

<%
    // Variables de connexion à la base de données
    String dbUrl = "jdbc:mysql://localhost:3306/hotel_management";
    String dbUser = "root";
    String dbPassword = "triki";
    Connection conn1 = null;
    PreparedStatement stmt1 = null;

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String idStr = request.getParameter("id");
        String label = request.getParameter("label");
        String capacityStr = request.getParameter("capacity");
        String priceStr = request.getParameter("price");

        // Vérification des paramètres
        if (idStr == null || idStr.trim().isEmpty()) {
            out.println("<p>Error: Room ID is required.</p>");
            return;
        }

        int id = Integer.parseInt(idStr);
        int capacity = Integer.parseInt(capacityStr);
        int price = Integer.parseInt(priceStr);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn1 = DriverManager.getConnection(dbUrl, dbUser, dbPassword); // Connexion à la base de données

            String insertQuery = "INSERT INTO roomtype (id, label, capacity, price) VALUES (?, ?, ?, ?)";
            stmt1 = conn1.prepareStatement(insertQuery);
            stmt1.setInt(1, id);  // Utilisation de stmt1 pour l'insertion
            stmt1.setString(2, label);
            stmt1.setInt(3, capacity);
            stmt1.setInt(4, price);

            int result = stmt1.executeUpdate();
            if (result > 0) {
                response.sendRedirect("profit.jsp");  // Redirection vers la page profit.jsp après ajout
            } else {
                out.println("<p>Error adding room.</p>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } finally {
            if (stmt1 != null) try { stmt1.close(); } catch (SQLException e) {}
            if (conn1 != null) try { conn1.close(); } catch (SQLException e) {}
        }
    }
%>

</body>
</html>





