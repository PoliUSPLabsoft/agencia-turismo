package model;

public class Cidade {
	
	int id;
	String nome;
	float avaliacao;
	String descricao;
	Transporte chegada, partida;
	Hotel hotel;
	
	public Cidade(int id, String nome, float avaliacao, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.avaliacao = avaliacao;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public float getAvaliacao() {
		return avaliacao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Transporte getChegada() {
		return chegada;
	}

	public void setChegada(Transporte chegada) {
		this.chegada = chegada;
	}

	public Transporte getPartida() {
		return partida;
	}

	public void setPartida(Transporte partida) {
		this.partida = partida;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
