package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TransporteDAO;
import model.Roteiro;

/**
 * Servlet implementation class Finalizar
 */
@WebServlet("/Finalizar")
public class Finalizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String redirecionamento;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Finalizar() {
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
		try {
			Enumeration<String> transportesIds = request.getAttributeNames();
			Roteiro roteiro = (Roteiro) request.getSession().getAttribute("roteiro2");
			while(transportesIds.hasMoreElements()){
				String idList = transportesIds.nextElement();
				String[] ids = idList.split(",| ");
				roteiro.setTransporte(ids, (int)request.getAttribute(idList));
			}
			throw new SQLException("dsds");
			//redirecionamento = "/jsp/hoteis.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			redirecionamento = "/jsp/erro.jsp";
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(redirecionamento);
		requestDispatcher.forward(request, response);
	}

}
