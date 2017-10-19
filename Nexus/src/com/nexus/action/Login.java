package com.nexus.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.nexus.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private HttpSession hs;
	private HttpServletRequest hsr;
	public String email;
	public String endereco;
	private String result;
	
	private Integer id;
	public String nome;
	public String senha;
	public String nivel;


	public String logar() {
		result = ERROR;
		LoginDAO dao = new LoginDAO();
		hs=hsr.getSession();
		
		if (dao.isExist(email, senha)) {
			
			hs.setAttribute("email",email );
			
			nivel = dao.pegaNivel(nivel);
			hs.setAttribute("nivel",nivel );
			
			endereco = dao.pegaEndereco(endereco);
			hs.setAttribute("endereco",endereco );
			
			result = SUCCESS;
			
		}else{
			hs.setAttribute("msg", "Usuario ou Senha Invalida");
			result = ERROR;
			
		}
		return result;
	}
	
	public String logout() {
		result = INPUT;
		hs=hsr.getSession();

		try{
			if(hs.getAttribute("email")==null){
				hs.invalidate();
				return INPUT;
			}else{
				hs.removeAttribute(email);
				result = INPUT;
			}

			return result;

		}catch(Exception e){}
		return INPUT;
	}

	
	public void setServletRequest(HttpServletRequest hsr) {
		this.hsr=hsr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
