package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteRoomTypeServlet
 */
@WebServlet("/DeleteRoomTypeServlet")
public class DeleteRoomTypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel_management";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "triki";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRoomTypeServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to an appropriate page or show error
        response.sendRedirect("profit.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get room ID from request
        String roomId = request.getParameter("id");

        // Validate room ID
        if (roomId == null || roomId.trim().isEmpty()) {
            sendErrorResponse(response, "Erreur : ID non fourni.");
            return;
        }

        Connection connection = null;
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Parse room ID
            int id = Integer.parseInt(roomId);

            // Check for existing reservations
            if (hasReservations(connection, id)) {
                sendErrorResponse(response, "Impossible de supprimer : Il existe des réservations pour ce type de chambre.");
                return;
            }

            // Delete room type
            if (deleteRoomType(connection, id)) {
                // Successful deletion
                response.sendRedirect("profit.jsp");
            } else {
                sendErrorResponse(response, "Erreur : Type de chambre introuvable.");
            }

        } catch (NumberFormatException e) {
            sendErrorResponse(response, "Erreur : Identifiant invalide.");
        } catch (ClassNotFoundException e) {
            sendErrorResponse(response, "Erreur : Le driver JDBC n'a pas été trouvé.");
        } catch (SQLException e) {
            sendErrorResponse(response, "Erreur de base de données : " + e.getMessage());
        } finally {
            // Close database connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log("Erreur lors de la fermeture de la connexion", e);
                }
            }
        }
    }

    /**
     * Check if there are any reservations for the given room type
     * @param connection Database connection
     * @param roomTypeId Room type ID to check
     * @return true if reservations exist, false otherwise
     * @throws SQLException if a database error occurs
     */
    private boolean hasReservations(Connection connection, int roomTypeId) throws SQLException {
        String checkReservationsSql = "SELECT COUNT(*) FROM reservation WHERE room_type_id = ?";
        try (PreparedStatement pstCheck = connection.prepareStatement(checkReservationsSql)) {
            pstCheck.setInt(1, roomTypeId);
            try (ResultSet rs = pstCheck.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    /**
     * Delete room type from database
     * @param connection Database connection
     * @param roomTypeId Room type ID to delete
     * @return true if deletion was successful, false otherwise
     * @throws SQLException if a database error occurs
     */
    private boolean deleteRoomType(Connection connection, int roomTypeId) throws SQLException {
        String deleteSql = "DELETE FROM RoomType WHERE id = ?";
        try (PreparedStatement pstDelete = connection.prepareStatement(deleteSql)) {
            pstDelete.setInt(1, roomTypeId);
            return pstDelete.executeUpdate() > 0;
        }
    }

    /**
     * Send error response with JavaScript alert
     * @param response HttpServletResponse
     * @param message Error message to display
     * @throws IOException if an I/O error occurs
     */
    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + message + "'); window.location.href='profit.jsp';</script>");
    }
}
