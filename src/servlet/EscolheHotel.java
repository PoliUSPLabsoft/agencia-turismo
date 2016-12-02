package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CidadeDAO;
import DAO.HotelDAO;
import model.Hotel;
import model.Roteiro;
import model.Cidade;
import model.Cliente;

/**
 * Servlet implementation class EscolheHotel
 */
@WebServlet("/EscolheHotel")
public class EscolheHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EscolheHotel() {
        super();
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
		List<Cidade> cidades = new ArrayList<>();
		CidadeDAO cidadeDAO = new CidadeDAO();
		HotelDAO hotelDAO = new HotelDAO();
		String redirecionamento;
		
		Roteiro roteiro;		
		try {
			Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
			Cidade cidadeNatal = cidadeDAO.getCidadeById(cliente.getCidadeId());
			String cidadesText = cidadeNatal.getId() + 
					" " + request.getParameter("cidades_escolhidas") +
					" " + cidadeNatal.getId();
			
			String nomeRoteiro = (String) request.getParameter("nomeRoteiro");
			request.getSession().setAttribute("nomeRoteiro", nomeRoteiro);
			
			String ids[] = cidadesText.split("(,| )");
			
			cidades = cidadeDAO.getCidades(ids);
			request.getSession().setAttribute("cidades", cidades);
			
			cidades.remove(0); //Removendo cidades natal;
			cidades.remove(cidades.size() - 1);
			
			List<Hotel> hoteis = hotelDAO.getHoteisByItinerario(cidades);			
			request.getSession().setAttribute("hoteis", hoteis);			
			request.setAttribute("hoteis", hoteis);
			
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
