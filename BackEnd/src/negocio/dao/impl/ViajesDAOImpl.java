package negocio.dao.impl;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import negocio.dao.factory.ChoferesDAOFactory;
import negocio.dao.interfaces.ChoferesDAO;
import negocio.dao.interfaces.ViajesDAO;
import negocio.dto.Camiones;
import negocio.dto.Choferes;
import negocio.dto.Provincias;
import negocio.dto.Viajes;
import util.MySQL;

public class ViajesDAOImpl implements ViajesDAO{
	
	private PreparedStatement preparedStatement;
	private CallableStatement callableStatement;
	private String query;
	private Connection connection;
	private Statement statement;
	
	
	@Override
	public Boolean addViaje(Viajes o) throws SQLException, IOException {

		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "INSERT INTO viajes ("
				+ "id_chofer,id_camion,id_origen,id_destino,distancia,tiempo_de_viaje,tanques_de_combustible" + ") " + "VALUES("
				+ "?,?,?,?,?,?,?" + ") ";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, o.getChofer());
		preparedStatement.setInt(2, o.getCamion());
		preparedStatement.setInt(3, o.getOrigen());
		preparedStatement.setInt(4, o.getDestino());
		preparedStatement.setInt(5, o.getDistancia());
		preparedStatement.setInt(6, o.getTiempoDeViaje());
		preparedStatement.setDouble(7, o.getTanquesDeCombustible());
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			preparedStatement.close();
			connection.close();
			return true;
		} else {
			preparedStatement.close();
			connection.close();
			return false;
		}
	
	}
	@Override
	public Boolean modifyViaje(Viajes o) throws SQLException {
		return null;
	}
	@Override
	public Viajes searchViaje(Viajes o) throws SQLException {
		return null;
	}
	@Override
	public List<Viajes> getViajes() throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "SELECT * FROM viajes";
		preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Viajes> viajesList = new ArrayList<>();
		while (resultSet.next()) {
			Viajes viajes = new Viajes();
			
			viajes.setIdViaje(resultSet.getInt(1));
			
			Choferes chofer = new Choferes();
			chofer.setIdChoferes(resultSet.getInt(2));
			viajes.setChofer(chofer);
			
			Camiones camion = new Camiones();
			camion.setIdCamiones(resultSet.getInt(3));
			viajes.setCamion(camion);
			
			Provincias origen = new Provincias();
			origen.setIdProvincia(resultSet.getInt(4));
			viajes.setOrigen(origen);
			
			Provincias destino = new Provincias();
			destino.setIdProvincia(resultSet.getInt(5));
			viajes.setDestino(destino);
			
			viajes.setDistancia(resultSet.getInt(6));
			viajes.setTiempoDeViaje(resultSet.getInt(7));
			viajes.setTanquesDeCombustible(resultSet.getDouble(8));
			
			viajesList.add(viajes);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return viajesList;
	}
	@Override
	public Boolean deleteViaje(int id) throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "DELETE FROM viajes WHERE id_viaje = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			preparedStatement.close();
			connection.close();
			return true;
		} else {
			preparedStatement.close();
			connection.close();
			return false;
		}
	}
	
	
	

}
