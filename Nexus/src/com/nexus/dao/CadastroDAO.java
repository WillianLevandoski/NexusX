package com.nexus.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.opensymphony.xwork2.ActionSupport;
import com.nexus.util.DBConnector;


public class CadastroDAO extends ActionSupport {

	public boolean CadastrarUsuario(String nome, String email, String senha,String endereco,Integer fone, Integer cep) {
		boolean res = false;
		Connection con = null;


		try {
			con = DBConnector.getConexao();
			Statement st = con.createStatement();
			String sql = "INSERT INTO login (nome,senha,nivel) VALUES ('"+nome+"',md5('"+senha+"'),'2')";
			st.executeUpdate(sql);
			String sql2 = "INSERT INTO usuario (idUsuario, login_nome, email, senha, endereco, fone, cep, nivel) VALUES (null,'"+nome+"','"+email+"',md5('"+senha+"'),'"+endereco+"','"+fone+"','"+cep+"','2')";
			st.executeUpdate(sql2);
			res = true;

		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}

	public boolean DeletarUsuario(String nome) {
		boolean res = false;
		Connection con = null;

		try {
			con = DBConnector.getConexao();
			Statement st = con.createStatement();
			String sql = "DELETE FROM `usuario` WHERE `Nome`='"+nome+"';";
			st.executeUpdate(sql);

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

	public boolean CadastraCreche(String nome, String email, String senha, Integer CNPJ,String endereco,Integer fone, Integer cep) {
		boolean res = false;
		Connection con = null;


		try {
			con = DBConnector.getConexao();
			Statement st = con.createStatement();
			String sql = "INSERT INTO login (nome,senha,nivel) VALUES ('"+nome+"',md5('"+senha+"'),'3')";
			st.executeUpdate(sql);
			String sql2 = "INSERT INTO creche (idCreche, login_nome, email, senha, endereco, cnpj, fone, cep, nivel) VALUES (null,'"+nome+"','"+email+"',md5('"+senha+"'),'"+endereco+"','"+CNPJ+"','"+fone+"','"+cep+"','3')";
			st.executeUpdate(sql2);
			res = true;

		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}
	
	public boolean CadastrarAluno(String id, String nome, String dataNascimento, String observacao) {
		boolean res = false;
		Connection con = null;

		try {
			con = DBConnector.getConexao();
			Statement st = con.createStatement();
			
			String sql = "INSERT INTO aluno (idAluno,usuario_idUsuario,nome,dataNasc,observacao) VALUES ('"+id+"','"+nome+"','"+dataNascimento+"','"+observacao+"')";
			st.executeUpdate(sql);
			res = true;

		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}
	
	public boolean ConsultarAlunoCadastrados(String id) {
		boolean res = false;
		Connection con = null;

		try {
			con = DBConnector.getConexao();
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM mydb.aluno where usuario_idUsuario = '"+id+"'";
			st.executeUpdate(sql);
			res = true;

		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}
	
	public boolean ConsultarAlunoCadastrado(String id) {
		boolean res = false;
		Connection con = null;

			try {
				con = DBConnector.getConexao();
				Statement st = con.createStatement();
				String sql = "SELECT * FROM mydb.aluno where usuario_idUsuario = '"+id+"'";
				ResultSet rs = st.executeQuery(sql);

				if(rs.next()){  
					res = true;
				}  

				con.close();  
			}catch(Exception e){e.printStackTrace();}  

		
		return res;
}


}
