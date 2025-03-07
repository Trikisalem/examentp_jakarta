package servlet;

import dao.ReservationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
    private ReservationDAO reservationDAO;

    @Override
    public void init() throws ServletException {
        Connection connection = (Connection) getServletContext().getAttribute("dbConnection");
        reservationDAO = new ReservationDAO(connection);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupération des données du formulaire
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String checkInDate = request.getParameter("checkInDate");
            String checkOutDate = request.getParameter("checkOutDate");
            int roomTypeId = Integer.parseInt(request.getParameter("roomTypeId"));

            // Insérer une réservation
            reservationDAO.addReservation(firstName, lastName, email, phone, checkInDate, checkOutDate, roomTypeId);

            // Redirection après succès
            request.setAttribute("message", "Réservation enregistrée avec succès !");
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Erreur lors de l'enregistrement de la réservation.");
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
    }
}