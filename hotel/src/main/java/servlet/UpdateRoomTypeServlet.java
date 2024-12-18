package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation for Room Type Update
 */
@WebServlet("/UpdateRoomTypeServlet")
public class UpdateRoomTypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel_management";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "triki";

    /**
     * Default constructor
     */
    public UpdateRoomTypeServlet() {
        super();
    }

    /**
     * Handle GET requests by retrieving room type details
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String id = request.getParameter("id");
        
        if (id == null || id.trim().isEmpty()) {
            sendErrorResponse(response, "ID de chambre invalide.");
            return;
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Prepare SQL to fetch room type details
            String sql = "SELECT * FROM RoomType WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));

            // Execute query
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Set attributes for the JSP to use
                request.setAttribute("id", resultSet.getInt("id"));
                request.setAttribute("label", resultSet.getString("label"));
                request.setAttribute("capacity", resultSet.getInt("capacity"));
                request.setAttribute("price", resultSet.getInt("price"));
                
                // Forward to edit page
                request.getRequestDispatcher("editRoom.jsp").forward(request, response);
            } else {
                sendErrorResponse(response, "Aucun type de chambre trouvé avec cet ID.");
            }

        } catch (ClassNotFoundException e) {
            sendErrorResponse(response, "Erreur : Driver de base de données non trouvé.");
        } catch (SQLException e) {
            sendErrorResponse(response, "Erreur de base de données : " + e.getMessage());
        } catch (NumberFormatException e) {
            sendErrorResponse(response, "ID de chambre invalide.");
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                log("Erreur lors de la fermeture des ressources", e);
            }
        }
    }

    /**
     * Handle POST requests for updating room type
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve form parameters
        String id = request.getParameter("id");
        String label = request.getParameter("label");
        String capacityStr = request.getParameter("capacity");
        String priceStr = request.getParameter("price");

        // Validate input
        if (id == null || id.trim().isEmpty() || 
            label == null || label.trim().isEmpty() || 
            capacityStr == null || capacityStr.trim().isEmpty() || 
            priceStr == null || priceStr.trim().isEmpty()) {
            sendErrorResponse(response, "Tous les champs sont obligatoires.");
            return;
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Parse numeric values
            int roomId = Integer.parseInt(id);
            int capacity = Integer.parseInt(capacityStr);
            int price = Integer.parseInt(priceStr);

            // Validate numeric values
            if (capacity <= 0 || price <= 0) {
                sendErrorResponse(response, "La capacité et le prix doivent être supérieurs à zéro.");
                return;
            }

            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Prepare SQL for update
            String updateSql = "UPDATE RoomType SET label = ?, capacity = ?, price = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1, label);
            preparedStatement.setInt(2, capacity);
            preparedStatement.setInt(3, price);
            preparedStatement.setInt(4, roomId);

            // Execute update
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                // Successful update
                response.sendRedirect("profit.jsp");
            } else {
                sendErrorResponse(response, "Aucune modification n'a été effectuée.");
            }

        } catch (ClassNotFoundException e) {
            sendErrorResponse(response, "Erreur : Driver de base de données non trouvé.");
        } catch (SQLException e) {
            sendErrorResponse(response, "Erreur de base de données : " + e.getMessage());
        } catch (NumberFormatException e) {
            sendErrorResponse(response, "Valeurs numériques invalides.");
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                log("Erreur lors de la fermeture des ressources", e);
            }
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
        response.getWriter().println("<script>alert('" + message + "'); window.location.href='profit.jsp';</script>");
    }
}