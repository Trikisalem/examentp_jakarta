package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/NewsletterActionServlet")
public class NewsletterActionServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -43101608327701033L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        int newsletterId = Integer.parseInt(request.getParameter("id"));
        
        // Se connecter à la base de données
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password")) {
            String query = "";
            
            if ("approve".equals(action)) {
                query = "UPDATE newsletters SET status = 'Allowed' WHERE id = ?";
            } else if ("reject".equals(action)) {
                query = "UPDATE newsletters SET status = 'Not Allowed' WHERE id = ?";
            }
            
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, newsletterId);
                stmt.executeUpdate();
                response.sendRedirect("newsletter.jsp");  // Redirige après action
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
