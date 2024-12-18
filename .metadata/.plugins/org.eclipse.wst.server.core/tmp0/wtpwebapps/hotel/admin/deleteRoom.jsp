<%@ page import="java.sql.*" errorPage="error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    // Configuration de la connexion � la base de donn�es
    Connection c = null;
    String roomId = request.getParameter("id");

    try {
        // Charge le driver JDBC pour MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Connexion � la base de donn�es (Remplacez les param�tres par vos propres informations)
        String url = "jdbc:mysql://localhost:3306/hotel_management"; // URL de la base de donn�es
        String username = "root"; // Nom d'utilisateur
        String password = "triki"; // Mot de passe
        
        c = DriverManager.getConnection(url, username, password);
        
        if (roomId != null && !roomId.trim().isEmpty()) {
            try {
                // Validation de l'ID pour s'assurer qu'il est un entier valide
                int id = Integer.parseInt(roomId);

                // V�rifier s'il y a des r�servations pour ce type de chambre
                String checkReservationsSql = "SELECT COUNT(*) FROM reservation WHERE room_type_id = ?";
                try (PreparedStatement pstCheck = c.prepareStatement(checkReservationsSql)) {
                    pstCheck.setInt(1, id);
                    ResultSet rs = pstCheck.executeQuery();
                    if (rs.next() && rs.getInt(1) > 0) {
                        // Si des r�servations existent pour ce type de chambre, emp�cher la suppression
                        out.println("<script>alert('Impossible de supprimer : Il existe des r�servations pour ce type de chambre.');</script>");
                    } else {
                        // Si aucune r�servation n'existe, proc�der � la suppression
                        String deleteSql = "DELETE FROM RoomType WHERE id = ?";
                        try (PreparedStatement pstDelete = c.prepareStatement(deleteSql)) {
                            pstDelete.setInt(1, id);
                            int rowsDeleted = pstDelete.executeUpdate();
                            if (rowsDeleted > 0) {
                                response.sendRedirect("profit.jsp"); // Redirection apr�s succ�s
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
                out.println("<script>alert('Erreur de base de donn�es : " + e.getMessage() + "');</script>");
            }
        } else {
            // Gestion du cas o� l'ID est null ou vide
            out.println("<script>alert('Erreur : ID non fourni.');</script>");
        }
    } catch (ClassNotFoundException e) {
        // Gestion de l'erreur si le driver JDBC n'est pas trouv�
        out.println("<script>alert('Erreur : Le driver JDBC n\'a pas �t� trouv�.');</script>");
    } catch (SQLException e) {
        // Gestion des erreurs de connexion � la base de donn�es
        out.println("<script>alert('Erreur de connexion � la base de donn�es : " + e.getMessage() + "');</script>");
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




