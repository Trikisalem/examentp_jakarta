package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationDAO {
    private final Connection connection;

    public ReservationDAO(Connection connection) {
        this.connection = connection;
    }

    public void addReservation(String firstName, String lastName, String email, String phone, String checkInDate, String checkOutDate, int roomTypeId) throws SQLException {
        String sql = "INSERT INTO reservation (guest_first_name, guest_last_name, guest_email, guest_phone, check_in_date, check_out_date, room_type_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, checkInDate);
            ps.setString(6, checkOutDate);
            ps.setInt(7, roomTypeId);
            ps.executeUpdate();
        }
    }
}