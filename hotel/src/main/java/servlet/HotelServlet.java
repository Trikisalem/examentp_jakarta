package servlet;

import model.Hotel;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HotelServlet")
public class HotelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Configuration de la base de données
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel_management";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "triki";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if (action == null) {
                listHotels(request, response);
            } else {
                switch (action) {
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "delete":
                        deleteHotel(request, response);
                        break;
                    default:
                        listHotels(request, response);
                        break;
                }
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if (action.equals("update")) {
                updateHotel(request, response);
            } else if (action.equals("add")) {
                addHotel(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    // Afficher la liste des hôtels
    private void listHotels(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, ServletException, IOException {
        ArrayList<Hotel> hotels = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM Hotel";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                hotels.add(new Hotel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("city"),
                        rs.getInt("stars"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getInt("agentId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("hotelList", hotels);
        request.getRequestDispatcher("hotel.jsp").forward(request, response);
    }

    // Afficher le formulaire d'édition
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Hotel hotel = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Hotel WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                hotel = new Hotel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("city"),
                        rs.getInt("stars"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getInt("agentId")
                );
            }
        }
        request.setAttribute("hotel", hotel);
        request.getRequestDispatcher("edithotel.jsp").forward(request, response);
    }

    // Ajouter un nouvel hôtel
    private void addHotel(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        int stars = Integer.parseInt(request.getParameter("stars"));
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        int agentId = Integer.parseInt(request.getParameter("agentId"));

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO Hotel (name, city, stars, description, image, agentId) VALUES (?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setString(2, city);
            stmt.setInt(3, stars);
            stmt.setString(4, description);
            stmt.setString(5, image);
            stmt.setInt(6, agentId);
            stmt.executeUpdate();
        }
        response.sendRedirect("HotelServlet");
    }

    // Mettre à jour un hôtel existant
    private void updateHotel(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        int stars = Integer.parseInt(request.getParameter("stars"));
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        int agentId = Integer.parseInt(request.getParameter("agentId"));

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE Hotel SET name = ?, city = ?, stars = ?, description = ?, image = ?, agentId = ? WHERE id = ?")) {
            stmt.setString(1, name);
            stmt.setString(2, city);
            stmt.setInt(3, stars);
            stmt.setString(4, description);
            stmt.setString(5, image);
            stmt.setInt(6, agentId);
            stmt.setInt(7, id);
            stmt.executeUpdate();
        }
        response.sendRedirect("HotelServlet");
    }

    // Supprimer un hôtel
    private void deleteHotel(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Hotel WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        response.sendRedirect("HotelServlet");
    }
}
