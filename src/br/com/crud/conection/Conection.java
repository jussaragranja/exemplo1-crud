package br.com.crud.conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conection {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/crud", "root", "root");
			return conexao;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->" + ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}

}
