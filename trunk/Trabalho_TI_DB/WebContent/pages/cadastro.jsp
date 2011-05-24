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
<script type="text/javascript"  >
function compararSenha() {

	var senha1 = document.getElementById("senha").value;
	var senha2 = document.getElementById("check").value;
	var obj = document.getElementById("seq");

	if (senha1 == senha2) {
		obj.setAttribute("style", "color: red; visibility:hidden;");
	} else {
		obj.setAttribute("style", "color: red; visibility:visible;");
	}

	if (senha2 == "") {
		obj.setAttribute("style", "color: red; visibility:hidden;");
	}

}

function checarSenha() {

	var senha1 = document.getElementById("senha").value;
	var senha2 = document.getElementById("check").value;
	var valido;

	if (senha1 == senha2) {
		valido=true;
	} else {
		valido=false;
		alert('As senhas devem ser iguais.');
	}
	return valido;

}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DoomBox</title>
<link rel="shortcut icon" href="/Trabalho_TI_DB/images/favicon.png" type="image/png" />
</head>
<body>
<form method="post" action="/Trabalho_TI_DB/Cadastro" onsubmit="return checarSenha();">
	<table style="padding-top: 15%;" align="center">
		<tr>
			<td>Nome:&nbsp;</td>
			<td>
			
				<input type="text" id="nome" name='nome' value='<c:out value="${nome}"/>' />
			
			<c:if test="${erroNome=='true' }">
				<font  color="red">Nome é obrigatório</font>
			</c:if>
			</td>
		</tr>
		<tr>
			<td>Login:&nbsp;</td>
			<td>
				<input type="text" id="login" name='login' value='<c:out value="${requestScope.login}"/>' />
			<c:if test="${erroLogin=='true' }">
				<font color="red">Login existente ou inválido</font>
			</c:if></td>
		</tr>
		<tr>
			<td>Senha:&nbsp;</td>
			<td><input type="password" id='senha' name="senha" />
			<c:if test="${erroLogin=='true' }">
				<font color="red">Senha é obrigatória</font>
			</c:if></td>
		</tr>
		<tr>
			<td>Confirmar Senha:&nbsp;</td>
			<td><input type="password" onkeyup="compararSenha();" id="check" />
			<font id="seq" style="visibility: hidden;" >Senhas não conferem</font>
			</td>
		</tr>
	</table>
	<div align="center">
	<html:submit value="Enviar" /> <html:button property="voltar" value="Voltar" onclick="javascript: document.location='http://localhost:8080/Trabalho_TI_DB/Login.do?method=loginPreparar';" ></html:button>
	</div>
</form>
</body>
</html>