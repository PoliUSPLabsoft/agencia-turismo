package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cidade;
import model.Hotel;

public class HotelDAO extends DAO {
	
	private final String SELECT_COMPLETE = "SELECT h.id, h.cidade_id, c.nome AS cidade_nome, h.preco, h.nome, h.avaliacao, h.descricao "
			+ "FROM hotel h "
			+ "INNER JOIN cidade c "
			+ "ON h.cidade_id = c.id ";			
	
	public Hotel putHotel(ResultSet resultSet) throws SQLException{
		int id = resultSet.getInt("id");
		String cidade = resultSet.getString("cidade_nome");
		int cidadeId = resultSet.getInt("cidade_id");
		int preco = resultSet.getInt("preco");
		String nome = resultSet.getString("nome");
		float avaliacao = resultSet.getFloat("avaliacao");
		String descricao = resultSet.getString("descricao");
		
		return new Hotel(id, cidade, cidadeId, preco, nome, avaliacao, descricao);
	}
	
	public List<Hotel> getHoteisByCidadeId(int idCidade) throws SQLException {
		List<Hotel> hoteis = new ArrayList<Hotel>();
		String sql = SELECT_COMPLETE + "WHERE cidade_id = " + idCidade;
		ResultSet resultSet = execute(sql);
		while(resultSet.next())
			hoteis.add(putHotel(resultSet));
		return hoteis;
	}
	
	public List<Hotel> getHoteisByItinerario(List<Cidade> itinerario) throws SQLException{
		List<Hotel> hoteis = new ArrayList<Hotel>();
		ResultSet resultSet;
		String sql = SELECT_COMPLETE + "WHERE cidade_id ";
		if (itinerario.size() > 0){
			if (itinerario.size() == 1)
				sql += "= " + itinerario.get(0).getId();
			else if (itinerario.size() > 1){
				sql += "IN (" + itinerario.get(0).getId();
				for(int i = 1; i < itinerario.size(); i++)
					sql += ", " + itinerario.get(i).getId();
				sql += ")";
			}
			resultSet = execute(sql);
			while(resultSet.next())
				hoteis.add(putHotel(resultSet));
		}
		return hoteis;
	}
	
	public List<List<Hotel>> getHoteisByItinerarioOrganizado(List<Cidade> itinerario) throws SQLException{
		List<List<Hotel>> list = new ArrayList<>();
		for(Cidade i: itinerario)
			list.add(getHoteisByCidadeId(i.getId()));
		return list;
	}
}