<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/doombox.js" ></script>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript">
function validarLogin(){
	var login=$('#login').val();
	var senha=$('#senha').val();
	if(login!=null && login!='' && login.length>0 && senha!=null && senha!='' && senha.length>0){
			$('#form').submit();
	}else{
		alert('Todos os campos devem ser preenchidos.');
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DoomBox</title>
<link rel="shortcut icon" href="images/favicon.png" type="image/png" />
</head>
<body>
<html:form styleId="form" action="Login.do?method=login">
	<table style="padding-top: 20%; padding-left: 200px;" align="center">
	<tr>
	<td>Login:</td>
	<td><html:text styleId="login" property="login"></html:text></td>
	</tr>
	<tr>
	<td>Senha:</td>
	<td><html:password styleId="senha" onkeydown="javascript: if (event.keyCode == 13) {validarLogin();}" property="senha"></html:password></td>
	<td style="width: 150px;">
	<font color="red"><c:if test="${requestScope.senhaI=='g'}">Senha incorreta</c:if></font> 
	</td>
	</tr>
	<tr>
	
	<td colspan="2" align="right"><html:button property="envio" value="Entrar" onclick="validarLogin();" ></html:button>&nbsp;<a href='http://localhost:8080/Trabalho_TI_DB/Cadastrar.do'>Cadastrar-se</a></td>
	</tr>
	</table>
	
	
	 
</html:form>
</body>
</html>