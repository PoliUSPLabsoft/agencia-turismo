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
@WebServlet("/CriarRoteiro")
public class CriarRoteiro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarRoteiro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClienteDAO clienteDAO= new ClienteDAO();
		CidadeDAO cidadeDAO = new CidadeDAO();	
		List<Cidade> cidades;
		String redirecionamento;
		try {
			Cliente cliente = new Cliente(400, "Samara", 1, "123", "123", "123", "Feminino");
			Cidade cidadeNatal = cidadeDAO.getCidadeById(cliente.getCidadeId());
			cidades = cidadeDAO.getCidades();
			if (cidadeNatal != null && cidades != null && cidades.size() > 0){
				request.setAttribute("cidadeNatal", cidadeNatal);
				request.setAttribute("cidades", cidades);
				redirecionamento = "/jsp/criarRoteiro.jsp";
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