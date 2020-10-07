package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import negocio.dto.Camiones;
import negocio.dto.Choferes;
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
	public void selectAllCamiones() throws SQLException, IOException {
		PreparedStatement preparedStatement;
		CallableStatement callableStatement;
		String query;
		Connection connection;
		Statement statement;
		MySQL mySQL = new MySQL();
		connection = mySQL.getConnection();
		query = "SELECT * FROM Camiones";
		preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Camiones> camionesList = new ArrayList<>();
		while(resultSet.next()) {
			Camiones camion = new Camiones();
			camion.setIdCamiones(resultSet.getInt(1));
			camion.setMarca(resultSet.getString(2));
			camion.setModelo(resultSet.getString(3));
			camion.setDominio(resultSet.getString(4));
			camion.setCategoria(resultSet.getInt(5));
			camion.setCargaMaximaTn(resultSet.getInt(6));
			camion.setLitrosTanque(resultSet.getInt(7));
			camion.setConsumoLitrosKm(resultSet.getInt(8));
			camionesList.add(camion);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		//return camionesList;
	}
		@Test
		public void getProperties() throws IOException {
			
			Properties prop = new Properties();
			InputStream in = testMySQLConn.class.getClassLoader().getResourceAsStream("db.properties");
			prop.load(in);
			
			System.out.println(prop.getProperty("db.url"));
		}
	
/*
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
*/
	/*
	@Test
	public void insertInto() throws SQLException  {
		
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(Calendar.YEAR, 1996);
		c.set(Calendar.MONTH, 0);
		c.set(Calendar.DATE, 15);
		java.util.Date utilDate = c.getTime();

		Choferes chofer = new Choferes();
		chofer.setNombre("Test");
		chofer.setApellido("apellido test");
		chofer.setDni(38555654);
		chofer.setFechaDeNacimiento("15-02-1996");
		chofer.setCategoria(5);
		chofer.setTelefono("1156468996");
		
//		o.setIdCamiones(1);
		PreparedStatement preparedStatement;
		CallableStatement callableStatement;
		String query;
		Connection connection;
		Statement statement;
		
		MySQL mySQL = new MySQL();
		connection = mySQL.getConnection();
		query = "INSERT INTO choferes (" + "nombre,apellido,dni,fecha_de_nacimiento,categoria,telefono" + ") "
				+ "VALUES(" + "?,?,?,?,?,?" + ") ";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, chofer.getNombre());
		preparedStatement.setString(2, chofer.getApellido());
		preparedStatement.setInt(3, chofer.getDni());
		preparedStatement.setString(4, chofer.getFechaDeNacimiento());
		preparedStatement.setInt(5, chofer.getCategoria());
		preparedStatement.setString(6, chofer.getTelefono());
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			preparedStatement.close();
			connection.close();
			System.out.println("ok");
		} else {
			preparedStatement.close();
			connection.close();
			System.out.println("no ok");
		}
	}*/
	@Test
	public void insertIntoProv() throws SQLException, IOException {
		// INSERT INTO provincias (provincia) VALUES (?);
		PreparedStatement preparedStatement;
		CallableStatement callableStatement;
		String query;
		Connection connection;
		Statement statement;
		
		MySQL mySQL = new MySQL();
		connection = mySQL.getConnection();
		query = "INSERT INTO provincias (provincia) VALUES (?)";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, "Neuquen");
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			preparedStatement.close();
			connection.close();
			System.out.println("ok");
		} else {
			preparedStatement.close();
			connection.close();
			System.out.println("no ok");
		}
	}

}
