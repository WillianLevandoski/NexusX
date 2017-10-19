package com.nexus.util;

import java.util.ArrayList;

public class Main extends MySqlUtil{ 
    public static void main (String[] args){
    	//String query = "INSERT INTO `grid`.`login` (`login`, `senha`, `nivel`) VALUES ('1', 'senha', '2')";
    	//insertSQL(query);
 //   	ArrayList resultado = selectSQL("SELECT * FROM grid.login");  
 //   	System.out.println(resultado);
    	
    	//selectSQL(ArrayList<String> campo, String tabela, String condicao) {
    	
    	String id = "idLogin";
    	String login = "login";
    	String senha = "senha";
    	
    	ArrayList<String> campo = new ArrayList<String>();
    	campo.add(id);
    	campo.add(login);
    	campo.add(senha);
    	ArrayList resul = selectSQL(campo, "grid.login", null);
    	System.out.println(resul);
    	
    }
}