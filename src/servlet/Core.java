package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.Roteiro;

/**
 * Servlet implementation class Core
 */
@WebServlet("/")
public class Core extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Core() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Substituir por login		
		Cliente cliente = new Cliente(400, "Samara", 1, "123", "123", "123", "Feminino");
		request.getSession().setAttribute("cliente", cliente);
		
		Roteiro roteiro = new Roteiro();
		roteiro.setCliente(cliente);
		
		request.getSession().setAttribute("roteiro", roteiro);
		//request.getSession().setAttribute("exemplo", "teste01");
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
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
