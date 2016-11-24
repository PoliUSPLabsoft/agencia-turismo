package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cidade;
import model.Hotel;
import model.Roteiro;
import model.Transporte;

public class RoteiroDAO extends DAO {
	
	
	public Roteiro getRoteiroById(int id) throws SQLException {
		CidadeDAO cidadeDAO = new CidadeDAO();
		TransporteDAO transporteDAO = new TransporteDAO();
		HotelDAO hotelDAO = new HotelDAO();
		Roteiro roteiro = new Roteiro();
		String estadiaSql = "SELECT id_cidade FROM estadia WHERE id_roteiro = " + id + " ORDER BY order ASC";
		ResultSet resultSet = execute(estadiaSql);
		List<String> cidadesIds = new ArrayList<String>();
		
		//get cidades
		while(resultSet.next()) {
			cidadesIds.add(resultSet.getString("id_cidade"));
		}
		String[] cidadesStringIds = new String[cidadesIds.size()];
		List<Cidade> cidades = cidadeDAO.getCidades(cidadesIds.toArray(cidadesStringIds));
		roteiro.setCidades(cidades);
		
		//get transportes
		String viagemSql = "SELECT * FROM viagem WHERE roteiro_id = " + id +  "ORDER BY cidade_from";
		ResultSet resultSetViagem = execute(viagemSql);
		List<Transporte> transportes = new ArrayList<Transporte>();
		while (resultSetViagem.next()) {
			String transporteId = resultSetViagem.getString("transporte_id");
			Transporte transporte = transporteDAO.getTransporteById(new Integer(transporteId));
			transportes.add(transporte);
		}
		
		//get hoteis
		String hotelSql = "SELECT * FROM hospedagem WHERE roteiro_id " + id + "ORDER BY posicao"; 
		ResultSet resultSetHotel = execute(hotelSql);
		List<Hotel> hoteis = new ArrayList<Hotel>();
		while(resultSetHotel.next()) {
			String hotelIdString = resultSetHotel.getString("hotel_id");
			int hotelId = new Integer(hotelIdString);
			Hotel hotel = hotelDAO.getHotelById(hotelId);
			hoteis.add(hotel);
		}
		roteiro.setHoteis(hoteis);
		
		return roteiro;
		}
	}