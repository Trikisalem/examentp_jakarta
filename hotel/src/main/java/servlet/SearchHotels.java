package servlet;

import model.Hotel;
import dao.HotelDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchHotels")
public class SearchHotels extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private HotelDAO hotelDAO;

    public SearchHotels() {
        super();
        // Initialisation de la connexion à la base de données avec gestion d'erreur
        try {
            // Assurez-vous de modifier les informations de connexion avec celles de votre base de données
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
            hotelDAO = new HotelDAO(connection); // Passer la connexion à l'objet HotelDAO
        } catch (SQLException e) {
            // Affichage de l'erreur de connexion avec un message plus explicite
            e.printStackTrace();
            throw new RuntimeException("Database connection error", e); // Arrêt de l'exécution avec un message d'erreur
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les critères de recherche depuis la requête HTTP
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String starsStr = request.getParameter("stars");

        // Vérification que les paramètres ne sont pas nuls ou vides
        if (name == null) name = "";
        if (city == null) city = "";
        if (starsStr == null || starsStr.isEmpty()) starsStr = "0"; // valeur par défaut si non précisé

        int stars = 0;
        try {
            stars = Integer.parseInt(starsStr); // Convertir stars en entier
        } catch (NumberFormatException e) {
            // Si l'utilisateur entre un non-nombre, utiliser la valeur par défaut de 0
            stars = 0;
        }

        // Rechercher les hôtels en fonction des critères
        List<Hotel> hotels = null;
        try {
            hotels = hotelDAO.searchHotels(name, city, stars);
        } catch (SQLException e) {
            // Log l'erreur d'exécution
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while searching hotels.");
        }

        // Passer les résultats à la JSP pour affichage
        request.setAttribute("hotels", hotels);

        // Rediriger vers la page JSP pour afficher les résultats
        request.getRequestDispatcher("searchHotels.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
