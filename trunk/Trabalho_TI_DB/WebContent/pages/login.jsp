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
<script type="text/javascript" src="js/doombox.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function validarLogin() {
		var login = $('#login').val();
		var senha = $('#senha').val();
		if (login != null && login != '' && login.length > 0 && senha != null
				&& senha != '' && senha.length > 0) {
			$('#form').submit();
		} else {
			alert('Todos os campos devem ser preenchidos.');
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DoomBox</title>
<link rel="shortcut icon" href="images/favicon.png" type="image/png" />
</head>
<body>
<form method="POST" action="j_security_check">
	Login: <input type="text" name="j_username">  <br/>
	Senha: <input type="password" name="j_password"> <br/>
	<input type="submit" value="OK"></form>
</body>
</html>