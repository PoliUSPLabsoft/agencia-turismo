package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cidade;
import model.Transporte;

public class TransporteDAO extends DAO {
	
	public Transporte putTransporte(ResultSet resultSet) throws SQLException{
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		int id = resultSet.getInt("id");
		Cidade from = cidadeDAO.getCidadeById(resultSet.getInt("cidade_from_id"));
		Cidade to = cidadeDAO.getCidadeById(resultSet.getInt("cidade_to_id"));
		int preco = resultSet.getInt("preco");
		String nome = resultSet.getString("nome");
		String tipo = resultSet.getString("tipo");
		String chegada = resultSet.getString("chegada");
		String saida = resultSet.getString("partida");
		return new Transporte(id, from, to, preco, nome, tipo, chegada, saida);
	}
	
	
	public List<Transporte> getTransportes(int idCidadeOrigem, int idCidadeDestino) throws SQLException {
		List<Transporte> transportes = new ArrayList<>();
		ResultSet resultSet = execute("SELECT * FROM transporte WHERE cidade_from_id = " + idCidadeOrigem + " AND cidade_to_id = " + idCidadeDestino);
		while(resultSet.next()) {
			transportes.add(putTransporte(resultSet));
		}
		return transportes;
	}
	public Transporte getTransporteById(int id) throws SQLException{
		ResultSet resultSet = execute("SELECT * FROM transporte WHERE id = " + id);
		if (resultSet.next())
			return putTransporte(resultSet);
		return null;
	}
}
