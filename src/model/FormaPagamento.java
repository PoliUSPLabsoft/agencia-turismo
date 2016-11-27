package model;

public enum FormaPagamento {
	DINHEIRO(1, "Dinheiro"),
	D�BITO(2, "Cart�o de D�bito"),
	CR�DITO(3, "Cart�o de Cr�dito"),
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
