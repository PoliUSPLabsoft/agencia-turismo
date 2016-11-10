package model;

public class Transporte {
	int id, cidade_from_id, cidade_to_id, preco;
	String nome, tipo, chegada, partida;
	
	public Transporte(int id, int cidade_from_id, int cidade_to_id, int preco, String nome, String tipo, String chegada,
			String partida) {
		super();
		this.id = id;
		this.cidade_from_id = cidade_from_id;
		this.cidade_to_id = cidade_to_id;
		this.preco = preco;
		this.nome = nome;
		this.tipo = tipo;
		this.chegada = chegada;
		this.partida = partida;
	}

	public int getId() {
		return id;
	}

	public int getCidade_from_id() {
		return cidade_from_id;
	}

	public int getCidade_to_id() {
		return cidade_to_id;
	}

	public int getPreco() {
		return preco;
	}

	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

	public String getChegada() {
		return chegada;
	}

	public String getPartida() {
		return partida;
	}

}
