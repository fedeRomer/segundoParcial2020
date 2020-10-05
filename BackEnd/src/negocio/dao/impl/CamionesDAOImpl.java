package negocio.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import negocio.dao.interfaces.CamionesDAO;
import negocio.dto.Camiones;
import util.MySQL;

public class CamionesDAOImpl implements CamionesDAO {
	private PreparedStatement preparedStatement;
	private CallableStatement callableStatement;
	private String query;
	private Connection connection;
	private Statement statement;

	@Override
	public Boolean addCamion(Camiones o) throws SQLException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "INSERT INTO camiones ("
				+ "marca,modelo,dominio,categoria,carga_maxima_tn,litros_tanque,consumo_litros_km"
				+ ") "
				+ "VALUES("
				+ "?,?,?,?,?,?,?"
				+ ") ";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, o.getMarca());
		preparedStatement.setString(2, o.getModelo());
		preparedStatement.setString(3, o.getDominio());
		preparedStatement.setInt(4, o.getCategoria());
		preparedStatement.setInt(5, o.getCargaMaximaTn());
		preparedStatement.setInt(6, o.getLitrosTanque());
		preparedStatement.setInt(7, o.getConsumoLitrosKm());
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
	public Boolean modifyCamion(Camiones o) throws SQLException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "UPDATE camiones "
				+ "SET marca = ?,modelo = ?,dominio = ?,categoria = ?,carga_maxima_tn = ?,litros_tanque = ?,consumo_litros_km = ? "
				+ "WHERE id_camiones = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, o.getMarca());
		preparedStatement.setString(2, o.getModelo());
		preparedStatement.setString(3, o.getDominio());
		preparedStatement.setInt(4, o.getCategoria());
		preparedStatement.setInt(5, o.getCargaMaximaTn());
		preparedStatement.setInt(6, o.getLitrosTanque());
		preparedStatement.setInt(7, o.getConsumoLitrosKm());
		preparedStatement.setInt(8, o.getIdCamiones());
		int resultSet = preparedStatement.executeUpdate(query);
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
	public Camiones searchCamion(Camiones o) throws SQLException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "SELECT * FROM camiones WHERE dominio LIKE ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(0, o.getDominio());
		ResultSet resultSet = preparedStatement.executeQuery();
		Camiones camion = new Camiones();
		while(resultSet.next()) {
			camion.setIdCamiones(resultSet.getInt(0));
			camion.setMarca(resultSet.getString(1));
			camion.setModelo(resultSet.getString(2));
			camion.setDominio(resultSet.getString(3));
			camion.setCategoria(resultSet.getInt(4));
			camion.setCargaMaximaTn(resultSet.getInt(5));
			camion.setLitrosTanque(resultSet.getInt(6));
			camion.setConsumoLitrosKm(resultSet.getInt(7));
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return camion;
	}

	@Override
	public List<Camiones> getCamiones() throws SQLException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "SELECT * FROM Camiones";
		preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Camiones> camionesList = new ArrayList<>();
		while(resultSet.next()) {
			Camiones camion = new Camiones();
			camion.setIdCamiones(resultSet.getInt(0));
			camion.setMarca(resultSet.getString(1));
			camion.setModelo(resultSet.getString(2));
			camion.setDominio(resultSet.getString(3));
			camion.setCategoria(resultSet.getInt(4));
			camion.setCargaMaximaTn(resultSet.getInt(5));
			camion.setLitrosTanque(resultSet.getInt(6));
			camion.setConsumoLitrosKm(resultSet.getInt(7));
			camionesList.add(camion);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return camionesList;
	}

}
