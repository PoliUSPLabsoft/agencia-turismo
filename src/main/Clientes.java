package main;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Clientes
 */
@WebServlet("/")
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Catalogo catalogo = new Catalogo();

    /**
     * Default constructor. 
     */
    public Clientes() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("size", catalogo.list().size());
		request.setAttribute("titulo", "Agência de Viagens");
		request.setAttribute("clientes", catalogo.list());
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		requestDispatcher.forward(request, response);
	}



}
