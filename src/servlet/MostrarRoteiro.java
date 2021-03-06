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
import model.Roteiro;

/**
 * Servlet implementation class MostrarRoteiro
 */
@WebServlet("/MostrarRoteiro")
public class MostrarRoteiro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarRoteiro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirecionamento;
		
		RoteiroDAO roteiroDAO = new RoteiroDAO();
		
		
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Roteiro roteiro = roteiroDAO.getRoteiroById(id);
			
			request.setAttribute("roteiro", roteiro);
			
			redirecionamento = "/jsp/hoteis.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			redirecionamento = "/jsp/erro.jsp";
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(redirecionamento);
		requestDispatcher.forward(request, response);
	}

}
