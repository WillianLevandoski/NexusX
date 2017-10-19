package com.nexus.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.nexus.util.DBConnector;


public class LoginDAO extends ActionSupport {

	public boolean isExist(String email, String senha) {
		boolean res = false;
		Connection con = null;
		try {
			con = DBConnector.getConexao();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM mydb.login WHERE nome ='"+email+"' AND Senha = md5('"+senha+"')";
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				res = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}
	
	public String pegaNivel(String nivel) {
		Connection con = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String user = (String) session.getAttribute("email");

		try {
			
			con = DBConnector.getConexao();
			Statement st = con.createStatement();
			String sql = "SELECT nivel FROM mydb.login where nome = '"+user+"';";
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()){  

				nivel=(rs.getString(1));  
	 
			}  

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return nivel;
	}
	
	public String pegaIDUsuarios(String idUsuario) {
		Connection con = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String user = (String) session.getAttribute("email");

		try {
			
			con = DBConnector.getConexao();
			Statement st = con.createStatement();
			String sql = "SELECT idUsuario FROM mydb.usuario where email = '"+user+"';";
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()){  

				idUsuario=(rs.getString(1));  
	 
			}  

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return idUsuario;
	}
	
	public String pegaIDCreche(String idCreche) {
		Connection con = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String user = (String) session.getAttribute("email");

		try {
			
			con = DBConnector.getConexao();
			Statement st = con.createStatement();
			String sql = "SELECT idCreche FROM mydb.creche where email = '"+user+"';";
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()){  

				idCreche=(rs.getString(1));  
	 
			}  

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return idCreche;
	}
	
	
	public String pegaEndereco(String endereco) {
		Connection con = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String user = (String) session.getAttribute("email");

		try {
			
			con = DBConnector.getConexao();
			Statement st = con.createStatement();
			String sql = "SELECT endereco FROM mydb.usuario where email = '"+user+"';";
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()){  

				endereco=(rs.getString(1));  
	 
			}  

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return endereco;
	}
	
	public String consultaVaga(String nivel) {
		Connection con = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String user = (String) session.getAttribute("email");

		try {
			
			con = DBConnector.getConexao();
			Statement st = con.createStatement();
			String sql = "SELECT nivel FROM mydb.login where nome = '"+user+"';";
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()){  

				nivel=(rs.getString(1));  
	 
			}  

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return nivel;
	}

}
