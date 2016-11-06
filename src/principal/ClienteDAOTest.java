package principal;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ClienteDAOTest {

	@Before
	public void setUp() throws Exception {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.resetClientes();		
	}

	@Test
	public void resetClientes() throws SQLException {
		ClienteDAO clienteDAO = new ClienteDAO();
		Assert.assertEquals(0, clienteDAO.getClientes().size());
	}
	
	@Test
	public void nomesPrimeiroClientes() throws SQLException {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.addCliente(new Cliente(56, "Julia", "123654871-02", "Rua Brasil, 485", "(11)4566-5641", "Feminino"));
		List<Cliente> clientes = clienteDAO.getClientes();
		Assert.assertEquals("Julia", clientes.get(clientes.size() - 1).getNome());
	}
	
	@Test
	public void contaAdiciona3Clientes() throws SQLException{
		ClienteDAO clienteDAO = new ClienteDAO();
		int nclientes = clienteDAO.getClientes().size();
		clienteDAO.addCliente(new Cliente(87, "Fabricio", "856147958-23", "Rua Falcao, 100", "(11)98547-6933", "Masculino"));
		clienteDAO.addCliente(new Cliente(11, "Carlos", "365748229-23", "Av. Angélica, 1300", "(41)8203-6501", "Masculino"));
		clienteDAO.addCliente(new Cliente(02, "Carol", "960251003-87", "Rua da Graça, 52", "(11)9854-8410", "Feminino"));
		Assert.assertEquals(nclientes + 3, clienteDAO.getClientes().size());
	}
	
	@Test(expected = SQLException.class)
	public void erroDuplicata() throws SQLException{
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.addCliente(new Cliente(87, "Andressa", "566012385-12", "Rua Miranda, 150", "(11)85693327", "Feminino"));
		clienteDAO.addCliente(new Cliente(87, "Andressa", "566012385-12", "Rua Miranda, 150", "(11)85693327", "Feminino"));
	}

}
