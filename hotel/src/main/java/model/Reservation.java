package model;

import java.sql.*;
import java.util.*;

public class Reservation {

    // Connexion à la base de données
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotel_management", // Base de données
                "root", // Utilisateur
                "triki" // Mot de passe
            );
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC MySQL non trouvé", e);
        }
    }

   
  
    public boolean makeReservation(String firstName, String lastName, String email, String phone,
                                    String checkIn, String checkOut, String roomType) {
        try {
            java.sql.Date checkInDate = java.sql.Date.valueOf(checkIn);
            java.sql.Date checkOutDate = java.sql.Date.valueOf(checkOut);

            try (Connection conn = getConnection()) {
                String query = "INSERT INTO Reservation " +
                               "(guest_first_name, guest_last_name, guest_email, guest_phone, " +
                               "check_in_date, check_out_date, room_type_id) " +
                               "VALUES (?, ?, ?, ?, ?, ?, (SELECT id FROM RoomType WHERE label = ?))";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.setString(3, email);
                pstmt.setString(4, phone);
                pstmt.setDate(5, checkInDate);
                pstmt.setDate(6, checkOutDate);
                pstmt.setString(7, roomType);
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
