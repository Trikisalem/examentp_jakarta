package connecteur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionTest {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_management"; // URL de la base de données
    private static final String USER = "root"; // Utilisateur de la base de données
    private static final String PASSWORD = "triki"; // Mot de passe de la base de données

    public Connection getConnection() throws SQLException {
        try {
            // Charger le driver MySQL JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC MySQL non trouvé", e);
        }
    }
}
