package com.nexus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.nexus.dao.CadastroDAO;
import com.nexus.dao.LoginDAO;

public class CadastroAction extends ActionSupport implements ServletRequestAware{
	
	private static final long serialVersionUID = 1L;
	private HttpSession hs;
	private HttpServletRequest hsr;
	public String id;
	public String nome;
	public String email;
	public String senha;
	public String cpf;
	public Integer cnpj;
	public String endereco;
	public Integer fone;
	public Integer cep;
	public String dataNascimento;
	public String obersevacao;

	
	private String result;
	
	public String CadastrarUsuario() {
		result = ERROR;

		CadastroDAO dao = new CadastroDAO();
		dao.CadastrarUsuario(nome, email, senha, endereco, fone,cep );
		
		result = SUCCESS;
		return result; 
	
	}
	
	public String CadastrarCreche() {
		result = ERROR;

		CadastroDAO dao = new CadastroDAO();
		dao.CadastraCreche(nome, email, senha, cnpj, endereco,fone,cep );
		
		result = SUCCESS;
		return result; 
	
	}
	
	public String CadastrarAluno() {
		result = ERROR;
//		System.out.println(id);
//		try{
//		
//		hs=hsr.getSession();
//		}catch (Exception ex){
//			System.out.println("Sessão Nula");
//
//		}
//		hs.setAttribute("email",email );
//		
		LoginDAO login = new LoginDAO();
		
		id = login.pegaIDUsuarios(id);

		CadastroDAO dao = new CadastroDAO();
		dao.CadastrarAluno(id, nome, dataNascimento, obersevacao);
		
		result = SUCCESS;
		return result; 
	
	}
	
	public String ConsultarAlunoCadastrado() {
		result = ERROR;

		LoginDAO login = new LoginDAO();
		
		id = login.pegaIDUsuarios(id);

		CadastroDAO dao = new CadastroDAO();
		if(	dao.ConsultarAlunoCadastrado(id)==true){
			result = SUCCESS;
		}

		return result; 
	
	}
	

	
	
	public HttpSession getHs() {
		return hs;
	}

	public void setHs(HttpSession hs) {
		this.hs = hs;
	}

	public HttpServletRequest getHsr() {
		return hsr;
	}

	public void setHsr(HttpServletRequest hsr) {
		this.hsr = hsr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getFone() {
		return fone;
	}
	public void setFone(Integer fone) {
		this.fone = fone;
	}
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Integer getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getObersevacao() {
		return obersevacao;
	}

	public void setObersevacao(String obersevacao) {
		this.obersevacao = obersevacao;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

}
