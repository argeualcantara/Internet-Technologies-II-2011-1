<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/doombox.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DoomBox</title>
<link rel="shortcut icon" href="images/favicon.png" type="image/png" />
</head>
<body>
<html:form  action="Cadastro.do?method=registrar" onsubmit="return checarSenha();">
	<table style="padding-top: 15%;" align="center">
		<tr>
			<td>Nome:&nbsp;</td>
			<td><html:text property="nome" />
			<c:if test="${erroNome=='true' }">
			<font  color="red">Nome é obrigatório</font>
			</c:if>
			</td>
		</tr>
		<tr>
			<td>Login:&nbsp;</td>
			<td><html:text property="login" />
			<c:if test="${erroLogin=='true' }">
			<font color="red">Login existente ou inválido</font>
			</c:if></td>
		</tr>
		<tr>
			<td>Senha:&nbsp;</td>
			<td><html:password property="senha" styleId="senha" /></td>
		</tr>
		<tr>
			<td>Confirmar Senha:&nbsp;</td>
			<td><input type="password" onkeyup="compararSenha();" id="check" />
			<font id="seq" style="visibility: hidden;" >Senhas não conferem</font>
			</td>
		</tr>
	</table>
	<div align="center">
	<html:submit value="Enviar" /> <html:button property="voltar" value="Voltar" onclick="javascript: document.location='http://localhost:8080/Trabalho_Ti_DoomBox/Inicio.do';" ></html:button>
	</div>
</html:form>
</body>
</html>