package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import DAO.TransporteDAO;
import model.Cidade;
import model.Transporte;

/**
 * Servlet implementation class EscolheTransporte
 */
@WebServlet("/EscolheTransportes")
public class EscolheTransporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EscolheTransporte() {
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
		
		TransporteDAO transporteDAO = new TransporteDAO();
		List<Transporte> transportes = new ArrayList<>();
		String redirecionamento;
		try {
			@SuppressWarnings("unchecked")
			List<Cidade> cidades = (List<Cidade>)request.getSession().getAttribute("cidades");
			for(int i = 1; i < cidades.size(); i++)
				transportes.addAll((Collection<Transporte>) transporteDAO.getTransportes(cidades.get(i-1).getId(), cidades.get(i).getId()));
			request.setAttribute("cidadeNatal", request.getParameter("cidadeNatal"));
			request.setAttribute("transportes", transportes);
			redirecionamento = "/jsp/transporte.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("stackTrace", e.getStackTrace());
			redirecionamento = "/jsp/erro.jsp";
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(redirecionamento);
		requestDispatcher.forward(request, response);
	}

}
