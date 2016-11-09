package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO extends DAO{
	
	public ClienteDAO(){
		super();
	}
	
	public Cliente putCliente (ResultSet resultSet) throws SQLException{
		return new Cliente(
				resultSet.getInt("id"),
				resultSet.getString("nome"),
				resultSet.getString("cpf"),
				resultSet.getString("endereco"),
				resultSet.getString("telefone"),
				resultSet.getString("genero")
				);
	}

	public List<Cliente> getClientes() throws SQLException{
		List<Cliente> clientes = new ArrayList<>();
	    ResultSet resultSet = statement.executeQuery("SELECT id, nome, cpf, endereco, telefone, genero FROM cliente");
		while(resultSet.next())
			clientes.add(putCliente(resultSet));
		return clientes;
	}
	
	public Cliente getClientById(int id) throws SQLException{
		ResultSet resultSet = statement.executeQuery("SELECT id, nome, cpf, endereco, telefone, genero FROM cliente WHERE id = " + id);
		return putCliente(resultSet);
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
