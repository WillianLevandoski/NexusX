<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div align="center">
		<h1>Login</h1>
		<hr>
		<s:form action="login">
			<s:textfield name="email" value="" size="24" label="EMAIL" />
			<s:password name="senha" value="" size="24" label="SENHA" />
			<s:submit value="Entrar" />
		</s:form>
	</div>
</body>
</html>