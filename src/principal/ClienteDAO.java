package principal;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
	java.sql.Connection connection;
	Statement statement;
	
	public ClienteDAO(){
		try{
			Class.forName("org.mariadb.jdbc.Driver");
	    	connection = DriverManager.getConnection("jdbc:mariadb://143.107.102.14:3306/mdb007?user=t1g7&password=;d4bMQ");
	   		statement = connection.createStatement();
		} catch (ClassNotFoundException e){
    		e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public List<Cliente> getClientes() throws SQLException{
		List<Cliente> clientes = new ArrayList<>();
	    	ResultSet resultSet = statement.executeQuery("SELECT id, nome, cpf, endereco, telefone, genero FROM cliente");
			while(resultSet.next()){
				clientes.add(new Cliente(
						resultSet.getInt("id"),
						resultSet.getString("nome"),
						resultSet.getString("cpf"),
						resultSet.getString("endereco"),
						resultSet.getString("telefone"),
						resultSet.getString("genero")
						));
			}
		return clientes;
	}
	
	public void addCliente(Cliente e) throws SQLException{
		String query = "INSERT INTO cliente values("
				+ e.getId() + ", '"
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
