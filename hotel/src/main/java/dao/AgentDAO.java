package dao;

import model.Agent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO pour gérer les opérations CRUD sur Agent.
 */
public class AgentDAO {

    private Connection connection;

    // Constructeur pour initialiser la connexion à la base de données
    public AgentDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Ajouter un nouvel agent.
     */
    public void addAgent(Agent agent) throws SQLException {
        String query = "INSERT INTO Agent (firstName, lastName, email, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, agent.getFirstName());
            preparedStatement.setString(2, agent.getLastName());
            preparedStatement.setString(3, agent.getEmail());
            preparedStatement.setString(4, agent.getPassword());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Mettre à jour un agent existant.
     */
    public void updateAgent(Agent agent) throws SQLException {
        String query = "UPDATE Agent SET firstName = ?, lastName = ?, email = ?, password = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, agent.getFirstName());
            preparedStatement.setString(2, agent.getLastName());
            preparedStatement.setString(3, agent.getEmail());
            preparedStatement.setString(4, agent.getPassword());
            preparedStatement.setInt(5, agent.getId());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Supprimer un agent par son identifiant.
     */
    public void deleteAgent(int id) throws SQLException {
        String query = "DELETE FROM Agent WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Récupérer un agent par son identifiant.
     */
    public Agent getAgentById(int id) throws SQLException {
        String query = "SELECT * FROM Agent WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Agent(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                    );
                }
            }
        }
        return null; // Retourne null si l'agent n'existe pas
    }

    /**
     * Récupérer tous les agents.
     */
    public List<Agent> getAllAgents() throws SQLException {
        List<Agent> agents = new ArrayList<>();
        String query = "SELECT * FROM Agent";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Agent agent = new Agent(
                    resultSet.getInt("id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
                );
                agents.add(agent);
            }
        }
        return agents;
    }

    /**
     * Vérifier si un email existe déjà dans la base de données.
     */
    public boolean emailExists(String email) throws SQLException {
        String query = "SELECT id FROM Agent WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Retourne true si un enregistrement existe
            }
        }
    }
}
