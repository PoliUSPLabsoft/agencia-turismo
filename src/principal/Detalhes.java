package principal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Detalhes
 */
@WebServlet("/Detalhes")
public class Detalhes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Detalhes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Catalogo catalogo = new Catalogo();
		int id = Integer.parseInt(request.getParameter("id"));
		//Cliente cliente = catalogo.getClient(id);
		//request.setAttribute("cliente", cliente);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/detalhes.jsp");
		requestDispatcher.forward(request, response);
	}

}
