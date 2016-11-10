package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Transporte;

public class TransporteDAO extends DAO {
	public List<Transporte> getTransportes(int idCidadeOrigem, int idCidadeDestino) throws SQLException {
		List<Transporte> transportes = new ArrayList<>();
		ResultSet resultSet = execute("SELECT * FROM transporte WHERE cidade_from_id = " + idCidadeOrigem + " AND cidade_to_id = " + idCidadeDestino);
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			int cidadeFromId = resultSet.getInt("cidade_from_id");
			int cidadeToId = resultSet.getInt("cidade_to_id");
			int preco = resultSet.getInt("preco");
			String nome = resultSet.getString("nome");
			String tipo = resultSet.getString("tipo");
			String chegada = resultSet.getString("chegada");
			String saida = resultSet.getString("partida");

			Transporte trans = new Transporte(id, cidadeFromId, cidadeToId, preco, nome, tipo, chegada, saida);
			transportes.add(trans);
		}
		return transportes;
	}
}
