package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cidade;

public class CidadeDAO extends DAO{
	
	public Cidade putCidade(ResultSet resultSet) throws SQLException{
		return new Cidade(
				resultSet.getInt("id"),
				resultSet.getString("nome"),
				resultSet.getFloat("avaliacao"),
				resultSet.getString("descricao")
				);
	}
	
	public List<Cidade> getCidades() throws SQLException{
		List<Cidade> cidades = new ArrayList<>();
	    ResultSet resultSet = statement.executeQuery("SELECT id, nome, avaliacao, descricao FROM cidade");
		while(resultSet.next())
			cidades.add(putCidade(resultSet));
		return cidades;
	}

}
