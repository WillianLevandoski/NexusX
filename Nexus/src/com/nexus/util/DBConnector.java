package com.nexus.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private final static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/MySql";
	private static String user ="root";
	private static String password = "root";

	public static Connection getConexao() {
	Connection conexao = null;
		try {
			Class.forName(driverName);
			conexao = (Connection) DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexao;
	}
}
