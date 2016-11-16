package servlet;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cidade;
import model.Cliente;
import DAO.CidadeDAO;
import DAO.ClienteDAO;

/**
 * Servlet implementation class CriarRoteiro
 */
@WebServlet("/EscolheCidade")
public class EscolheCidade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EscolheCidade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> cidades;
		String redirecionamento;
		try {
			Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
			Cidade cidadeNatal = cidadeDAO.getCidadeById(cliente.getCidadeId());
			cidades = cidadeDAO.getCidades();
			if (cidadeNatal != null && cidades != null && cidades.size() > 0){
				request.getSession().setAttribute("cidadeNatal", cidadeNatal);
				request.setAttribute("cidades", cidades);
				redirecionamento = "/jsp/cidade.jsp";
			} else
				throw new SQLException("Nenhum resultado encontrado!!");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("stackTrace", e.getStackTrace());
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
