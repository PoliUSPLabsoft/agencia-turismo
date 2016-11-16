package model;

public class Transporte {
	int id, preco;
	String nome, tipo, chegada, partida;
	Cidade from, to;
	
	public Transporte(int id, Cidade from, Cidade to, int preco, String nome, String tipo, String chegada,
			String partida) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.preco = preco;
		this.nome = nome;
		this.tipo = tipo;
		this.chegada = chegada;
		this.partida = partida;
	}

	public int getId() {
		return id;
	}

	public Cidade getCidadeFrom() {
		return from;
	}

	public Cidade getCidadeTo() {
		return to;
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