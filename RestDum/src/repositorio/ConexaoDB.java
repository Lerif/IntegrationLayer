package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDB {
	
	public Connection conectarDB() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost/geladeirasdb", "postgres", "oloco");
		} catch (Exception error) {
			return null;
		}
	}
}