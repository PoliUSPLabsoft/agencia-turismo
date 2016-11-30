package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cidade;

public class CidadeDAO extends DAO{
	
	private final String SELECT_COMPLETE = "SELECT id, nome, avaliacao, descricao FROM cidade ";
	
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
	    ResultSet resultSet = execute(SELECT_COMPLETE);
		while(resultSet.next())
			cidades.add(putCidade(resultSet));
		return cidades;
	}
	
	public List<Cidade> getCidadesExcept(int id) throws SQLException{
		List<Cidade> cidades = new ArrayList<>();
	    ResultSet resultSet = execute(SELECT_COMPLETE + "WHERE id <> " + id);
		while(resultSet.next())
			cidades.add(putCidade(resultSet));
		return cidades;
	}
	
	
	public List<Cidade> getCidades(String[] ids) throws SQLException{
		List<Cidade> cidades = new ArrayList<>();
		if (ids.length > 0){
			String sql = SELECT_COMPLETE + "WHERE id ";
			if (ids.length == 1)
				sql += "= " + ids[0];
			else
				sql += "IN (" + ids[0];
				for(int i = 1; i < ids.length; i++)
					sql += ", " + ids[i];
				sql += ")";
			ResultSet resultSet = execute(sql);
			while(resultSet.next())
				cidades.add(putCidade(resultSet));
			cidades.add(cidades.get(0));
		}
		return cidades;
	}
	
	public Cidade getCidadeById(int id) throws SQLException{
		String sql = SELECT_COMPLETE + "WHERE id = " + id;
		ResultSet resultSet = execute(sql);
		if (resultSet.next())
			return putCidade(resultSet);
		else
			return null;
	}

}
