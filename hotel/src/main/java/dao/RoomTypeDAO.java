package dao;

import model.RoomType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO pour gérer les opérations CRUD sur RoomType.
 */
public class RoomTypeDAO {

    private Connection connection;

    /**
     * Constructeur pour initialiser la connexion à la base de données.
     *
     * @param connection La connexion JDBC à utiliser pour les opérations.
     */
    public RoomTypeDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Ajouter un nouveau type de chambre.
     *
     * @param roomType Le type de chambre à ajouter.
     * @throws SQLException En cas d'erreur SQL.
     */
    public void addRoomType(RoomType roomType) throws SQLException {
        if (roomType == null) {
            throw new IllegalArgumentException("Le type de chambre ne peut pas être null.");
        }
        String query = "INSERT INTO RoomType (label, capacity, price) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, roomType.getLabel());
            preparedStatement.setInt(2, roomType.getCapacity());
            preparedStatement.setDouble(3, roomType.getPrice());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de l'ajout du type de chambre: " + e.getMessage(), e);
        }
    }

    /**
     * Mettre à jour un type de chambre existant.
     *
     * @param roomType Le type de chambre à mettre à jour.
     * @throws SQLException En cas d'erreur SQL.
     */
    public void updateRoomType(RoomType roomType) throws SQLException {
        if (roomType == null || roomType.getId() <= 0) {
            throw new IllegalArgumentException("Le type de chambre est invalide ou l'ID est manquant.");
        }
        String query = "UPDATE RoomType SET label = ?, capacity = ?, price = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, roomType.getLabel());
            preparedStatement.setInt(2, roomType.getCapacity());
            preparedStatement.setDouble(3, roomType.getPrice());

            preparedStatement.setInt(4, roomType.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la mise à jour du type de chambre: " + e.getMessage(), e);
        }
    }

    /**
     * Supprimer un type de chambre par son identifiant.
     *
     * @param id L'identifiant du type de chambre à supprimer.
     * @throws SQLException En cas d'erreur SQL.
     */
    public void deleteRoomType(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("L'ID du type de chambre doit être supérieur à 0.");
        }
        String query = "DELETE FROM RoomType WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la suppression du type de chambre: " + e.getMessage(), e);
        }
    }

    /**
     * Récupérer un type de chambre par son identifiant.
     *
     * @param id L'identifiant du type de chambre.
     * @return Le type de chambre correspondant, ou null s'il n'existe pas.
     * @throws SQLException En cas d'erreur SQL.
     */
    public RoomType getRoomTypeById(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("L'ID du type de chambre doit être supérieur à 0.");
        }
        String query = "SELECT * FROM RoomType WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new RoomType(
                    );
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la récupération du type de chambre par ID: " + e.getMessage(), e);
        }
        return null; // Retourne null si le type de chambre n'existe pas
    }

    /**
     * Récupérer tous les types de chambres.
     *
     * @return Une liste contenant tous les types de chambres.
     * @throws SQLException En cas d'erreur SQL.
     */
    public List<RoomType> getAllRoomTypes() throws SQLException {
        List<RoomType> roomTypes = new ArrayList<>();
        String query = "SELECT * FROM RoomType";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                RoomType roomType = new RoomType(
                );
                roomTypes.add(roomType);
            }
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la récupération des types de chambres: " + e.getMessage(), e);
        }
        return roomTypes;
    }
}
