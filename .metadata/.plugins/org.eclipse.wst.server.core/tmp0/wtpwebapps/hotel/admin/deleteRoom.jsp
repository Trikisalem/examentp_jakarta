<%@ page import="java.sql.*" errorPage="error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    // Configuration de la connexion à la base de données
    Connection c = null;
    String roomId = request.getParameter("id");

    try {
        // Charge le driver JDBC pour MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Connexion à la base de données (Remplacez les paramètres par vos propres informations)
        String url = "jdbc:mysql://localhost:3306/hotel_management"; // URL de la base de données
        String username = "root"; // Nom d'utilisateur
        String password = "triki"; // Mot de passe
        
        c = DriverManager.getConnection(url, username, password);
        
        if (roomId != null && !roomId.trim().isEmpty()) {
            try {
                // Validation de l'ID pour s'assurer qu'il est un entier valide
                int id = Integer.parseInt(roomId);

                // Vérifier s'il y a des réservations pour ce type de chambre
                String checkReservationsSql = "SELECT COUNT(*) FROM reservation WHERE room_type_id = ?";
                try (PreparedStatement pstCheck = c.prepareStatement(checkReservationsSql)) {
                    pstCheck.setInt(1, id);
                    ResultSet rs = pstCheck.executeQuery();
                    if (rs.next() && rs.getInt(1) > 0) {
                        // Si des réservations existent pour ce type de chambre, empêcher la suppression
                        out.println("<script>alert('Impossible de supprimer : Il existe des réservations pour ce type de chambre.');</script>");
                    } else {
                        // Si aucune réservation n'existe, procéder à la suppression
                        String deleteSql = "DELETE FROM RoomType WHERE id = ?";
                        try (PreparedStatement pstDelete = c.prepareStatement(deleteSql)) {
                            pstDelete.setInt(1, id);
                            int rowsDeleted = pstDelete.executeUpdate();
                            if (rowsDeleted > 0) {
                                response.sendRedirect("profit.jsp"); // Redirection après succès
                            } else {
                                out.println("<script>alert('Erreur : Type de chambre introuvable.');</script>");
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                // Gestion de l'erreur si l'ID n'est pas un entier valide
                out.println("<script>alert('Erreur : Identifiant invalide.');</script>");
            } catch (SQLException e) {
                // Gestion des erreurs SQL
                out.println("<script>alert('Erreur de base de données : " + e.getMessage() + "');</script>");
            }
        } else {
            // Gestion du cas où l'ID est null ou vide
            out.println("<script>alert('Erreur : ID non fourni.');</script>");
        }
    } catch (ClassNotFoundException e) {
        // Gestion de l'erreur si le driver JDBC n'est pas trouvé
        out.println("<script>alert('Erreur : Le driver JDBC n\'a pas été trouvé.');</script>");
    } catch (SQLException e) {
        // Gestion des erreurs de connexion à la base de données
        out.println("<script>alert('Erreur de connexion à la base de données : " + e.getMessage() + "');</script>");
    } finally {
        // Fermeture de la connexion
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                out.println("<script>alert('Erreur lors de la fermeture de la connexion : " + e.getMessage() + "');</script>");
            }
        }
    }
%>




