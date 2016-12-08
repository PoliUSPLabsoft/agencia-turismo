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
import model.Cidade;
import model.Cliente;
import model.Roteiro;

/**
 * Servlet implementation class EscolheFormaPagamento
 */
@WebServlet("/EscolheFormaPagamento")
public class EscolheFormaPagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String redirecionamento;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EscolheFormaPagamento() {
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
		RoteiroDAO roteiroDAO = new RoteiroDAO();
		try {
			Roteiro roteiro = new Roteiro();
			roteiro.setCliente((Cliente) request.getSession().getAttribute("cliente"));
			List<Cidade> cidades = (List<Cidade>) request.getSession().getAttribute("cidades");
			roteiro.setCidades(cidades);
			for(int i = 0; i < cidades.size() - 1; i++){
				int[] ids = {i, i+1};
				String atributo = i + ", " + (i+1);
				String param = (String) request.getParameter(atributo);
				int id = Integer.parseInt(param);
				roteiro.setTransporte(ids, id);
			}
			String nomeRoteiro = (String) request.getSession().getAttribute("nomeRoteiro");
			roteiro.setName(nomeRoteiro);
			Cidade cidadeNatal = (Cidade) request.getSession().getAttribute("cidadeNatal");
			roteiro.setCidadeNatal(cidadeNatal);
			roteiroDAO.salvaRoteiro(roteiro);
			
			request.getSession().setAttribute("roteiro", roteiro);
			request.setAttribute("roteiro", roteiro);
			redirecionamento = "/jsp/criarRoteiro/mostrarRoteiro.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			redirecionamento = "/jsp/erro.jsp";
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(redirecionamento);
		requestDispatcher.forward(request, response);
	}

}
