package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class AddRoomTypeServlet
 */
@WebServlet("/AddRoomTypeServlet")
public class AddRoomTypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomTypeServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to the form page or show an error
        response.sendRedirect("roomtype.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get form parameters
        String label = request.getParameter("label");
        String capacity = request.getParameter("capacity");
        String price = request.getParameter("price");

        // Validate input
        if (label == null || capacity == null || price == null || 
            label.trim().isEmpty() || capacity.trim().isEmpty() || price.trim().isEmpty()) {
            out.println("<script>alert('All fields are required'); window.location.href='roomtype.jsp';</script>");
            return;
        }

        // Get database connection from ServletContext
        Connection connection = (Connection) getServletContext().getAttribute("connection");

        if (connection == null) {
            out.println("<script>alert('Database connection error'); window.location.href='roomtype.jsp';</script>");
            return;
        }

        // Prepare SQL statement
        String sql = "INSERT INTO RoomType (label, capacity, price) VALUES (?, ?, ?)";
        
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            // Set parameters
            pst.setString(1, label);
            pst.setInt(2, Integer.parseInt(capacity));
            pst.setInt(3, Integer.parseInt(price));

            // Execute insert
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                // Successful insertion
                response.sendRedirect("roomtypes.jsp?success=true");
            } else {
                // Insertion failed
                out.println("<script>alert('Failed to add room type'); window.location.href='roomtype.jsp';</script>");
            }
        } catch (NumberFormatException e) {
            // Handle invalid number format
            out.println("<script>alert('Invalid capacity or price'); window.location.href='roomtype.jsp';</script>");
        } catch (SQLException e) {
            // Handle database errors
            out.println("<script>alert('Database error: " + e.getMessage() + "'); window.location.href='roomtype.jsp';</script>");
        }
    }
}