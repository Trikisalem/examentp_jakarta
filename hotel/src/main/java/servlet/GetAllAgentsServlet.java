package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/GetAllAgentsServlet")
public class GetAllAgentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetAllAgentsServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            deleteAgent(request, response);
        } else if ("edit".equals(action)) {
            editAgent(request, response);
        } else {
            listAgents(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("save".equals(action)) {
            saveAgent(request, response);
        }
    }

    private void deleteAgent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String agentId = request.getParameter("id");

        try (Connection conn = getConnection()) {
            String sql = "DELETE FROM Account WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, Integer.parseInt(agentId));
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("GetAllAgentsServlet");
    }

    private void editAgent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String agentId = request.getParameter("agentId");
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        request.setAttribute("agentId", agentId);
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        
        request.getRequestDispatcher("agent-form.jsp").forward(request, response); // forward to a form to edit
    }

    private void saveAgent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String agentId = request.getParameter("agentId");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try (Connection conn = getConnection()) {
            PreparedStatement ps;
            if (agentId != null && !agentId.isEmpty()) {
                // Update agent
                String sql = "UPDATE Account SET username = ?, password = ?, email = ? WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, email);
                ps.setInt(4, Integer.parseInt(agentId));
            } else {
                // Insert new agent
                String sql = "INSERT INTO Account (username, password, email, role) VALUES (?, ?, ?, 'agent')";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, email);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("GetAllAgentsServlet");
    }

    private void listAgents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = getConnection()) {
            String sql = "SELECT id, username, email FROM Account WHERE role = 'agent'";
            try (PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                
                request.setAttribute("agents", rs);
                request.getRequestDispatcher("agent-list.jsp").forward(request, response); // forward to the list page
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/hotel_management";
        String user = "root";
        String pass = "triki";
        return DriverManager.getConnection(url, user, pass);
    }
}
