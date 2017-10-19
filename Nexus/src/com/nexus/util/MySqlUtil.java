package com.nexus.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class MySqlUtil {

	public static ArrayList selectSQL(String query) {
		ArrayList resultado = null;
		Connection conexao = null;
		try {
			conexao = DBConnector.getConexao();
			PreparedStatement prepStmt = conexao.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			resultado = resultSetToArrayList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}

	public static boolean updatetSQL(String query) throws SQLException {
		boolean res = false;
		Connection conexao = null;
		try {
			conexao = DBConnector.getConexao();
			Statement st = conexao.createStatement();
			st.executeUpdate(query);
			res = true;
		} catch (SQLException e) {
			if (conexao != null) {
				try {
					System.err.print("Rollback efetuado na transação");
					conexao.rollback();
				} catch (SQLException e2) {
					System.err.print("Erro na transação!" + e2);
				}
			}
		} finally {
			if (conexao != null) {
				conexao.close();
			}
			conexao.setAutoCommit(true);
		}
		return res;
	}
	
	public static boolean insertSQL(String query) throws SQLException {
		boolean res = false;
		res = updatetSQL(query);
		return res;
	}
	
	public static boolean deleteSQL(String query) throws SQLException {
		boolean res = false;
		res = updatetSQL(query);
		return res;
	}

	public static ArrayList selectSQL(ArrayList<String> campo, String tabela, String condicao) {
		String query = "SELECT ";
		for (int count = 0; count < campo.size(); count++) {
			if (count == campo.size() - 1)
				query = query + campo.get(count) + " FROM " + tabela;
			else
				query = query + campo.get(count) + ", ";
		}
		if (condicao != null) {
			query = query + " " + condicao;
		}
		ArrayList resultado = selectSQL(query);
		return resultado;
	}

	public static ArrayList selectSQL(String query, ArrayList<String> vars) {
		ArrayList resultado = new ArrayList();
		Connection conexao = null;
		try {
			PreparedStatement prepStmt = conexao.prepareStatement(query);
			for (int count = 0; count < vars.size(); count++) {
				prepStmt.setString(count, vars.get(count));
				count++;
			}
			query = prepStmt.toString();
			resultado = selectSQL(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}

	public static boolean insertSQL(String query, ArrayList<String> vars) {
		boolean res = false;
		Connection conexao = null;
		try {
			PreparedStatement prepStmt = conexao.prepareStatement(query);

			for (int count = 0; count < vars.size(); count++) {
				prepStmt.setString(count, vars.get(count));
			}
			query = prepStmt.toString();
			res = insertSQL(query);
		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		} finally {
			try {
				conexao.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}

	public static boolean updateSQL(String query, ArrayList<String> vars) {
		boolean res = false;
		Connection conexao = null;
		try {
			PreparedStatement prepStmt = conexao.prepareStatement(query);

			for (int count = 0; count < vars.size(); count++) {
				prepStmt.setString(count, vars.get(count));
			}
			query = prepStmt.toString();
			res = insertSQL(query);
		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		} finally {
			try {
				conexao.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}

	public static ArrayList resultSetToArrayList(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		ArrayList list = new ArrayList();
		while (rs.next()) {
			HashMap row = new HashMap(columns);
			for (int i = 1; i <= columns; ++i) {
				row.put(md.getColumnName(i), rs.getObject(i));
			}
			list.add(row);
		}
		return list;
	}
}
