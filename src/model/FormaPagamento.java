package model;

public enum FormaPagamento {
	DINHEIRO(1, "Dinheiro"),
	DÉBITO(2, "Cartão de Débito"),
	CRÉDITO(3, "Cartão de Crédito"),
	CHEQUE(4, "Cheque");
	
	int id;
	String nome;
	
	FormaPagamento(int id, String nome){
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
