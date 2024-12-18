package servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.RoomTypeDAO;
import model.RoomType;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

public class RoomTypeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données de la base de données
        RoomTypeDAO dao = new RoomTypeDAO(null);
        List<RoomType> roomTypes = null;
		try {
			roomTypes = dao.getAllRoomTypes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Ajouter les données à la requête
        request.setAttribute("roomTypes", roomTypes);

        // Rediriger vers la JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("roomtypes.jsp");
        dispatcher.forward(request, response);
    }
}
