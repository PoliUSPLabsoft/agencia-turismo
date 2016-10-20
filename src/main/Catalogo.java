package main;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	List<Cliente> clientes = new ArrayList<>();
	
	public Catalogo(){
		clientes.add(new Cliente(0, 18, "123456789", "25846789603", "Fátima", "Rua da Consolação, 310", "fatima"));
		clientes.add(new Cliente(1, 28, "326858743", "25846789603", "Ronaldo", "Rua da Consolação, 311", "rony"));
		clientes.add(new Cliente(2, 14, "321123321", "25846789603", "Jefferson", "Rua da Consolação, 312", "jef"));
		clientes.add(new Cliente(3, 35, "321622330", "25846789603", "Caetano", "Av. Paulista, 1900", "destroyer914"));
		clientes.add(new Cliente(4, 89, "098371325", "25846789603", "Julia", "Rua Chile, 210", "gostosa41"));
		clientes.add(new Cliente(5, 50, "123456789", "25846789603", "Carlos", "Rua da Consolação, 310", "dididi"));
		
	}
	
	public List<Cliente> list(){
		return this.clientes;
	}
	
	public Cliente getClient (int id){
		Cliente resp = null;
		for (Cliente cliente: this.clientes){
			if (cliente.getId() == id)
				resp = cliente;
		}
		return resp;
	}
	
}
