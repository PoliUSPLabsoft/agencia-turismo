package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Hotel;

public class HotelDAO extends DAO {
	public List<Hotel> getHotel(int idCidade) throws SQLException {
		List<Hotel> hoteis = new ArrayList<Hotel>();
		ResultSet resultSet = execute("SELECT * FROM Hotel WHERE cidade_id = " + idCidade);
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			int cidadeId = resultSet.getInt("cidade_id");
			int preco = resultSet.getInt("preco");
			String nome = resultSet.getString("nome");
			float avaliacao = resultSet.getFloat("avaliacao");
			String descricao = resultSet.getString("descricao");
			
			Hotel hot = new Hotel(id, cidadeId, preco, nome, avaliacao, descricao);
			hoteis.add(hot);
		}
		return hoteis;
	}
}