package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MySQL {

	private String driver;
	private String url;
	private String username;
	private String password;

	private Connection connection = null;

	public MySQL() {
		Properties properties = new Properties();
		//tomar desde properties

		this.driver = "com.mysql.jdbc.Driver";
		this.url = "jdbc:mysql://localhost/testdb";
		this.username = "root";
		this.password = "1234";
	}

	public Connection getConnection() {
		if (this.connection == null) {
			try {
				Class.forName(this.driver);

				this.connection = DriverManager.getConnection(this.url, this.username, this.password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return this.connection;
	}

	public void closeConnection() {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
