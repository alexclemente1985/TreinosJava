package br.com.treinaweb.agenda.factories;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnectionFactory {
	public static Connection createConnection() throws IOException,SQLException {
		InputStream is = JDBCConnectionFactory.class.getClassLoader().getResourceAsStream("application.properties");
		if (is == null) {
			throw new FileNotFoundException("O arquivo de configuração do banco de dados não foi encontrado.");
		}
		Properties props = new Properties();
		props.load(is);
		Connection connection = DriverManager.getConnection(props.getProperty("urlConnection"),
				props.getProperty("userConnection"), props.getProperty("password"));
		
		return connection;
	}
}
