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
import java.sql.SQLException;

/**
 * Servlet implementation for Agent Management
 */
@WebServlet("/AddAgentServlet")
public class AddAgentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel_management";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "triki";

    /**
     * Default constructor
     */
    public AddAgentServlet() {
        super();
    }

    /**
     * Handle GET requests by redirecting to agent management page
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("agent.jsp");
    }

    /**
     * Handle POST requests for adding or updating agents
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve form parameters
        String action = request.getParameter("action");
        String agentId = request.getParameter("agentId");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Validate input
        if (username == null || password == null || email == null || 
            username.trim().isEmpty() || password.trim().isEmpty() || email.trim().isEmpty()) {
            sendErrorResponse(response, "Tous les champs sont obligatoires.");
            return;
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Determine if this is an update or insert operation
            if (agentId != null && !agentId.trim().isEmpty()) {
                // Update existing agent
                String updateSql = "UPDATE Account SET username = ?, password = ?, email = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(updateSql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);
                preparedStatement.setInt(4, Integer.parseInt(agentId));
            } else {
                // Insert new agent
                String insertSql = "INSERT INTO Account (username, password, email, role) VALUES (?, ?, ?, 'agent')";
                preparedStatement = connection.prepareStatement(insertSql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);
            }

            // Execute the database operation
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Successful operation
                response.sendRedirect("agent.jsp");
            } else {
                sendErrorResponse(response, "Aucune modification n'a été effectuée.");
            }

        } catch (ClassNotFoundException e) {
            sendErrorResponse(response, "Erreur : Driver de base de données non trouvé.");
        } catch (SQLException e) {
            sendErrorResponse(response, "Erreur de base de données : " + e.getMessage());
        } catch (NumberFormatException e) {
            sendErrorResponse(response, "Erreur : Identifiant invalide.");
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
        response.getWriter().println("<script>alert('" + message + "'); window.location.href='agent.jsp';</script>");
    }
}