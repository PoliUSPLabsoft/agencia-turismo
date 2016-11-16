package model;

import java.util.List;

public class Roteiro {
	int id;
	Cliente cliente;
	List<Cidade> cidades;
	List<Transporte> transportes;
	
	public Roteiro(Cliente cliente){
		this.cliente = cliente;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	public void setTransportes(List<Transporte> transportes) {
		this.transportes = transportes;
	}
	public int getId() {
		return id;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public List<Transporte> getTransportes() {
		return transportes;
	}
	public Cliente getCliente() {
		return cliente;
	}
}
