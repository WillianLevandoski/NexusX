<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Efetuado</title>
</head>
<body>

	<table>
		<tr>
			<td>
				<h1>
					Bem-Vindo <s:property value="#session.nome" />!
				</h1>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td><s:a href="logout.action?id=logout">logout</s:a></td>
		</tr>
	</table>

	<s:set var="Nivel" scope="session" value="#session.nivel" />
	

	<h1>Nivel <s:property value="Nivel" />!</h1> 
	
	<s:if test='Nivel == "1"'>
	


		<td><h4><a href="http://localhost:8080/nexus/cadastro/cadastroCreche.jsp">Cadastrar Creche</a></h4></td>



	</s:if>
	<s:elseif test='Nivel == "2"'>

		<a href="http://localhost:8080/nexus/cadastro/cadastroAluno.jsp">Cadastrar Aluno</a>
			<br>

		<a href="http://localhost:8080/nexus/vaga/pesquisarVaga.jsp">Analisar Opções de
			Vagas</a>
		<br>
		<a href="consultarPonto.action?id=PontoDAO">Consultar Referencias</a>
		<br>
		<a href="consultarPonto.action?id=PontoDAO">Efetuar Pré-Matricula</a>
		<br>
		<a href="consultarPonto.action?id=PontoDAO">Consultar Lista de
			Espera</a>
		<br>
		<a href="consultarPonto.action?id=PontoDAO">Analisar Opções de
			Vagas</a>
		<br>
		<a href="consultarPonto.action?id=PontoDAO">Efetivar Matricula</a>
		<br>
		<a href="consultarPonto.action?id=PontoDAO">Disponibilizar
			Referencia</a>
	</s:elseif>
	<s:elseif test='Nivel == "3"'>
	
		<a href="http://localhost:8080/Nexus/vaga/criarVaga.jsp">Criar Vaga</a>
			<br>
		<a href="consultarPonto.action?id=PontoDAO">Consultar Matricula</a>
		
	</s:elseif>

</body>
</html>