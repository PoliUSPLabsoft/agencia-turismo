package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HotelDAO;
import DAO.RoteiroDAO;
import DAO.TransporteDAO;
import model.Cidade;
import model.Hotel;
import model.Roteiro;
import model.Transporte;

/**
 * Servlet implementation class SugerirRoteiro
 */
@WebServlet("/SugerirRoteiro")
public class SugerirRoteiro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String redirecionamento;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SugerirRoteiro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RoteiroDAO roteiroDAO = new RoteiroDAO();
			Map<Integer, Roteiro> roteiros = roteiroDAO.getRoteiros();
			
			request.setAttribute("roteiros", roteiros);
			redirecionamento = "/jsp/sugerirRoteiro/roteiros.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			redirecionamento = "/jsp/erro.jsp";
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(redirecionamento);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
