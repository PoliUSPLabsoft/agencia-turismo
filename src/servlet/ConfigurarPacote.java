package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cidade;
import model.Cliente;
import model.Hotel;
import model.Pacote;
import model.Transporte;
import DAO.CidadeDAO;
import DAO.HotelDAO;
import DAO.TransporteDAO;

/**
 * Servlet implementation class EscolheHotel
 */
@WebServlet("/ConfigurarPacote")
public class ConfigurarPacote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigurarPacote() {
        super();
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
				redirecionamento = "/jsp/VenderPacotes-EscolherCidade.jsp";
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
		CidadeDAO cidadeDAO = new CidadeDAO();
		HotelDAO hotelDAO = new HotelDAO();
		TransporteDAO transporteDAO = new TransporteDAO();
		String redirecionamento;
		
		Pacote pacote = new Pacote();
		
		try {
			String cidadesText = request.getParameter("cidadeNatal") + ", " + request.getParameter("cidades_escolhidas");
			
			String ids[] = cidadesText.split(",");
			
			List<Cidade> cidades = cidadeDAO.getCidades(ids);				
			//List<Hotel> hoteis = hotelDAO.getHoteisByItinerario(cidades);
			Map<Cidade, List<Hotel>> hoteisDisponiveis = new HashMap<>();
			Map<Cidade, List<Transporte>> transportesDisponiveis = new HashMap<>();
			
			for(Cidade cidade : cidades) {
				List<Hotel> hoteisDessaCidade = hotelDAO.getHoteisByCidadeId(cidade.getId());
				hoteisDisponiveis.put(cidade, hoteisDessaCidade);
				int nextCidadeId;
				nextCidadeId = cidades.indexOf(cidade) == cidades.size() - 1 ? 0 : cidades.indexOf(cidade)+1;
				List<Transporte> transportesDessaCidade = transporteDAO.getTransportes(cidade.getId(), cidades.get(nextCidadeId).getId());
				transportesDisponiveis.put(cidade, transportesDessaCidade);
			}
			pacote.setCidades(cidades);
			request.setAttribute("hoteisDisponiveis", hoteisDisponiveis);
			request.setAttribute("transportesDisponiveis", transportesDisponiveis);
			request.setAttribute("pacote", pacote);
			
			redirecionamento = "/jsp/VenderPacotes-ConfigurarPacote.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			redirecionamento = "/jsp/erro.jsp";
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(redirecionamento);
		requestDispatcher.forward(request, response);
	}
}
