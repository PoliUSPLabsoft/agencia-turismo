package DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	java.sql.Connection connection;
	Statement statement;
	
	protected String SELECT_COMPLETE;
	
	public DAO(){
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
	
	public ResultSet execute(String sql) throws SQLException{
		ResultSet resultSet;
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		statement.close();
		return resultSet;
	}
}
