package negocio.dao.impl;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import negocio.dao.interfaces.ChoferesDAO;
import negocio.dto.Choferes;
import util.MySQL;

public class ChoferesDAOImpl implements ChoferesDAO {
	private PreparedStatement preparedStatement;
	private CallableStatement callableStatement;
	private String query;
	private Connection connection;
	private Statement statement;

	@Override
	public Boolean addChofer(Choferes o) throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "INSERT INTO choferes (" + "nombre,apellido,dni,fecha_de_nacimiento,categoria,telefono" + ") "
				+ "VALUES(" + "?,?,?,?,?,?" + ") ";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, o.getNombre());
		preparedStatement.setString(2, o.getApellido());
		preparedStatement.setInt(3, o.getDni());
		preparedStatement.setString(4, o.getFechaDeNacimiento());
		preparedStatement.setInt(5, o.getCategoria());
		preparedStatement.setString(6, o.getTelefono());
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
	public Boolean modifyChofer(Choferes o) throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "UPDATE choferes "
				+ "SET nombre = ?,apellido = ?,dni = ?,fecha_de_nacimiento = ?,categoria = ?,telefono = ? "
				+ "WHERE id_choferes = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, o.getNombre());
		preparedStatement.setString(2, o.getApellido());
		preparedStatement.setInt(3, o.getDni());
		preparedStatement.setString(4, o.getFechaDeNacimiento());
		preparedStatement.setInt(5, o.getCategoria());
		preparedStatement.setString(6, o.getTelefono());
		preparedStatement.setInt(7, o.getIdChoferes());
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
	public Choferes searchChofer(Choferes o) throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "SELECT * FROM choferes WHERE id_choferes = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, o.getIdChoferes());
		ResultSet resultSet = preparedStatement.executeQuery();
		Choferes chofer = new Choferes();
		while (resultSet.next()) {
			chofer.setIdChoferes(resultSet.getInt(1));
			chofer.setNombre(resultSet.getString(2));
			chofer.setApellido(resultSet.getString(3));
			chofer.setDni(resultSet.getInt(4));
			chofer.setFechaDeNacimiento(resultSet.getString(5));
			chofer.setCategoria(resultSet.getInt(6));
			chofer.setTelefono(resultSet.getString(7));
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return chofer;
	}

	@Override
	public List<Choferes> getChoferes() throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "SELECT * FROM choferes";
		preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Choferes> choferesList = new ArrayList<>();
		while (resultSet.next()) {
			Choferes chofer = new Choferes();
			chofer.setIdChoferes(resultSet.getInt(1));
			chofer.setNombre(resultSet.getString(2));
			chofer.setApellido(resultSet.getString(3));
			chofer.setDni(resultSet.getInt(4));
			chofer.setFechaDeNacimiento(resultSet.getString(5));
			chofer.setCategoria(resultSet.getInt(6));
			chofer.setTelefono(resultSet.getString(7));
			choferesList.add(chofer);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return choferesList;
	}

	@Override
	public Boolean deleteChofer(int id) throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "DELETE FROM Choferes WHERE id_choferes = ?";
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
