package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RoteiroDAO;
import model.Cliente;
import model.Hotel;
import model.Roteiro;

/**
 * Servlet implementation class VenderRoteiro
 */
@WebServlet("/VenderRoteiro")
public class VenderRoteiro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VenderRoteiro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirecionamento;
			
		RoteiroDAO roteiroDAO = new RoteiroDAO();
		
		
		try {
			Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
			List<Roteiro> roteiros = roteiroDAO.getRoteiros();
			
			request.setAttribute("cliente", cliente);
			request.setAttribute("roteiros", roteiros);
			request.getSession().setAttribute("roteiros", roteiros);
			
			redirecionamento = "/jsp/hoteis.jsp";
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
