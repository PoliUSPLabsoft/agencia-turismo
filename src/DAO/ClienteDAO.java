package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO extends DAO{
	
	
	public ClienteDAO(){
		super();
		this.SELECT_COMPLETE = "SELECT id, nome, cidade_id, cpf, endereco, telefone, genero FROM cliente";
	}
	
	public Cliente putCliente (ResultSet resultSet) throws SQLException{
		return new Cliente(
				resultSet.getInt("id"),
				resultSet.getString("nome"),
				resultSet.getInt("cidade_id"),
				resultSet.getString("cpf"),
				resultSet.getString("endereco"),
				resultSet.getString("telefone"),
				resultSet.getString("genero")
				);
	}

	public List<Cliente> getClientes() throws SQLException{
		List<Cliente> clientes = new ArrayList<>();
	    ResultSet resultSet = execute(SELECT_COMPLETE);
		while(resultSet.next())
			clientes.add(putCliente(resultSet));
		return clientes;
	}
	
	public Cliente getClientById(int id) throws SQLException{
		ResultSet resultSet = execute(SELECT_COMPLETE + " WHERE id = " + id);
		if (resultSet.next())
			return putCliente(resultSet);
		else
			return null;
	}
	
	public void addCliente(Cliente e) throws SQLException{
		String query = "INSERT INTO cliente values("
				+ e.getNome() + "' , '"
				+ e.getCpf() + "' , '"
				+ e.getEndereco() + "' , '"
				+ e.getTelefone() + "' , '"
				+ e.getGenero() + "')";
		
		statement.executeQuery(query);
	}
	
	public void resetClientes(){
		String query = "DELETE FROM cliente";
		try {
			statement.executeQuery(query);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
