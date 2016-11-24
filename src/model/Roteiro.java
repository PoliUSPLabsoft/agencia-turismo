package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import DAO.TransporteDAO;

public class Roteiro implements Serializable {
	private static final long serialVersionUID = -7121797199679360740L;
	Integer id;
	Cliente cliente;
	List<Cidade> cidades;
	List<Hotel> hoteis;
	List<String> cidadeIds;
	List<Transporte> transportes;
	HashMap<Cidade, Hotel> hospedagem;
	
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

	public List<String> getCidadeIds() {
		return cidadeIds;
	}

	public void setCidadeIds(String[] cidadeIds) {
		this.cidadeIds = Arrays.asList(cidadeIds);
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public HashMap<Cidade, Hotel> getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(HashMap<Cidade, Hotel> hospedagem) {
		this.hospedagem = hospedagem;
	}

	public List<Hotel> getHoteis() {
		return hoteis;
	}

	public void setHoteis(List<Hotel> hoteis) {
		this.hoteis = hoteis;
	}
	
	public Cidade getCidadeById(int k){
		for(Cidade cidade: cidades)
			if(cidade.getId() == k)
				return cidade;
		return null;
	}
	
	public Hotel getHotelById(int k){
		for(Hotel hotel: hoteis)
			if(hotel.getId() == k)
				return hotel;
		return null;
	}
	
	public void setTransporte(String[] ids, int valor) throws SQLException{
		TransporteDAO transporteDAO = new TransporteDAO();
		Transporte transporte = transporteDAO.getTransporteById(valor);
		transporte.setFrom(getCidadeById(Integer.parseInt(ids[0].trim())));
		transporte.setTo(getCidadeById(Integer.parseInt(ids[1].trim())));
		
		transportes.add(transporte);
	}
	
	public int getPreco(){
		int preco = 0;
		for(Hotel hotel: hoteis)
			preco += hotel.getPreco() * hotel.getNdias();
		for (Transporte transporte: transportes)
			preco += transporte.getPreco();		
		return preco;
	}
	
}
