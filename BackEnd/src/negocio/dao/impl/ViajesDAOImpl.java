package negocio.dao.impl;

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
	public Boolean addViaje(Viajes o) throws SQLException {
		return false;
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
	public List<Viajes> getViajes() throws SQLException {
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
			viajes.setTanquesDeCombustible(resultSet.getInt(8));
			
			viajesList.add(viajes);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return viajesList;
	}
	
	
	

}
