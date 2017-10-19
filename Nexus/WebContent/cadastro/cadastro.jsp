<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro</title>
</head>
<body>
	<div align="Center">
		<h1>Cadastrar Usuario</h1>
		<hr>
	</div>
	<div align="Center">
		<s:form action="cadastrarUsuario">
			<s:textfield name="nome" value="" size="50" label="Nome Completo" />
			<s:textfield name="email" value="" size="50" label="Email" />
			<s:textfield name="senha" value="" size="50" label="Senha" />		
			<s:textfield name="endereco" value="" size="50" label="Endereço" />
			<s:textfield name="fone" value="" size="50" label="Fone" />
			<s:textfield name="cep" value="" size="50" label="Cep" />
	</div>
	<br>
	<s:submit align="Center" value="Cadastrar" />
	</s:form>

</body>
</html>