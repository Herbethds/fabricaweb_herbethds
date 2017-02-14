package br.com.fabricadeprogamador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb2", "postgres", "post" );
		} catch (SQLException e) {
			// Relançando a exception
			throw new RuntimeException(e);
		}
	}
}
