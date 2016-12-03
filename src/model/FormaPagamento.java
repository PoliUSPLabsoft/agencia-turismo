package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FormaPagamento {
	
	private Map<Integer, String> formas = new HashMap<Integer, String>();
	
	public FormaPagamento(){
		formas.put(1, "Dinheiro");	
		formas.put(2, "Cartão de Débito");
		formas.put(3, "Cartão de Crédito");
		formas.put(4, "Cheque");
	}
	
	public String get(int i){
		return formas.get(i);
	}
	
	public List<String> getValues(){
		return (List<String>) formas.values();
	}
	
	public Set<Map.Entry<Integer, String>> getEntries(){
		return formas.entrySet();
	}

}
