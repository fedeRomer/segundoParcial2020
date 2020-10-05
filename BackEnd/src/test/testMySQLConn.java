package test;

import static org.junit.Assert.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import negocio.dto.Camiones;
import negocio.dto.Usuario;
import util.MySQL;

public class testMySQLConn {

	@Test
	public void testQuery() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb?" + "user=root&password=1234");
		String query = "SELECT * FROM testdb.usuario;";

		PreparedStatement p = conn.prepareStatement(query);
		ResultSet resultSet;
		List<Object> paramList = new ArrayList<Object>();
		// paramList.add("Germany");
		// p.setString(1, paramList.get(0).toString());
		System.out.println("ejecutando query: " + p);
		resultSet = p.executeQuery();
		ResultSetMetaData rsmd = resultSet.getMetaData();

		int columnsNumber = rsmd.getColumnCount();
		while (resultSet.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				if (i > 1)
					System.out.print("");
				String columnValue = resultSet.getString(i);
				System.out.print("Columna: " + rsmd.getColumnName(i) + " Valor: " + columnValue + "\n");

			}
			System.out.println("\n");
		}
	}

	@Test
	public void getUser() {
		String username = "admin@gmail.com";
		String password = "1234";

		PreparedStatement preparedStatement;
		CallableStatement callableStatement;
		String query;
		Connection connection;
		Statement statement;

		try {

			MySQL mySQL = new MySQL();
			connection = mySQL.getConnection();
			query = "select * from USUARIO where username=? and password=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet set = preparedStatement.executeQuery();
			Usuario usuario = new Usuario();
			while (set.next()) {
				usuario.setId(set.getInt(1));
				usuario.setUsername(set.getString(2));
				usuario.setPassword(set.getString(3));
			}
			set.close();
			preparedStatement.close();
			connection.close();

			usuario.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void insertInto()  {
		
		Camiones o = new Camiones();
		o.setMarca("Scania");
		o.setModelo("R 2012");
		o.setDominio("I3IYF29");
		o.setCategoria(5);
		o.setCargaMaximaTn(16);
		o.setLitrosTanque(1400);
		o.setConsumoLitrosKm(10);
//		o.setIdCamiones(1);
		PreparedStatement preparedStatement;
		CallableStatement callableStatement;
		String query;
		Connection connection;
		Statement statement;
		
		MySQL mySQL = new MySQL();
		connection = mySQL.getConnection();
		query = "INSERT INTO camiones ("
				+ "marca,modelo,dominio,categoria,carga_maxima_tn,litros_tanque,consumo_litros_km"
				+ ") "
				+ "VALUES("
				+ "?,?,?,?,?,?,?"
				+ ") ";
		try {

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, o.getMarca());
			preparedStatement.setString(2, o.getModelo());
			preparedStatement.setString(3, o.getDominio());
			preparedStatement.setInt(4, o.getCategoria());
			preparedStatement.setInt(5, o.getCargaMaximaTn());
			preparedStatement.setInt(6, o.getLitrosTanque());
			preparedStatement.setInt(7, o.getConsumoLitrosKm());
			//preparedStatement.setInt(8, o.getIdCamiones());
			int resultSet = preparedStatement.executeUpdate();
			if (resultSet == 1) {
				preparedStatement.close();
				connection.close();
			} else {
				preparedStatement.close();
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
