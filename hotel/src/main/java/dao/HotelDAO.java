package dao;

import model.Hotel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {
    private Connection connection;

    // Constructeur de la classe HotelDAO qui initialise la connexion à la base de données
    public HotelDAO(Connection connection) {
        this.connection = connection;
    }

    // Récupérer tous les hôtels
    public List<Hotel> getAllHotels() throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotels"; // Query to get all hotels
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hotel hotel = new Hotel(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("city"),
                    rs.getInt("stars"),
                    rs.getString("description"),
                    rs.getString("image"),
                    rs.getInt("agent_id")
                );
                hotels.add(hotel);
            }
        }
        return hotels;
    }

    // Rechercher des hôtels par ville
    public List<Hotel> getHotelsByCity(String city) throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotels WHERE city LIKE ?"; // Query for city-based search
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + city + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hotel hotel = new Hotel(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("city"),
                    rs.getInt("stars"),
                    rs.getString("description"),
                    rs.getString("image"),
                    rs.getInt("agent_id")
                );
                hotels.add(hotel);
            }
        }
        return hotels;
    }

    // Rechercher des hôtels par étoiles
    public List<Hotel> getHotelsByStars(int stars) throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotels WHERE stars = ?"; // Query for stars-based search
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, stars);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hotel hotel = new Hotel(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("city"),
                    rs.getInt("stars"),
                    rs.getString("description"),
                    rs.getString("image"),
                    rs.getInt("agent_id")
                );
                hotels.add(hotel);
            }
        }
        return hotels;
    }

    // Rechercher des hôtels par ville et étoiles
    public List<Hotel> getHotelsByCityAndStars(String city, int stars) throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotels WHERE city LIKE ? AND stars = ?"; // Query for both city and stars-based search
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + city + "%");
            ps.setInt(2, stars);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hotel hotel = new Hotel(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("city"),
                    rs.getInt("stars"),
                    rs.getString("description"),
                    rs.getString("image"),
                    rs.getInt("agent_id")
                );
                hotels.add(hotel);
            }
        }
        return hotels;
    }
    public List<Hotel> searchHotels(String name, String city, int stars) throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM hotels WHERE 1=1"); // Requête de base

        // Ajouter les conditions de recherche
        if (!name.isEmpty()) {
            sql.append(" AND name LIKE ?");
        }
        if (!city.isEmpty()) {
            sql.append(" AND city LIKE ?");
        }
        if (stars > 0) {
            sql.append(" AND stars = ?");
        }

        try (PreparedStatement ps = connection.prepareStatement(sql.toString())) {
            int index = 1;
            
            // Ajouter les paramètres à la requête préparée
            if (!name.isEmpty()) {
                ps.setString(index++, "%" + name + "%");
            }
            if (!city.isEmpty()) {
                ps.setString(index++, "%" + city + "%");
            }
            if (stars > 0) {
                ps.setInt(index, stars);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hotel hotel = new Hotel(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("city"),
                    rs.getInt("stars"),
                    rs.getString("description"),
                    rs.getString("image"),
                    rs.getInt("agent_id")
                );
                hotels.add(hotel);
            }
        }

        return hotels;
    }

}
