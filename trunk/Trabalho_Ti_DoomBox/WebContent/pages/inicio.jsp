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
<style type="text/css">
ul 
{
list-style:url("images/favicon.png");
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DoomBox</title>
<link rel="shortcut icon" href="images/favicon.png" type="image/png" />
</head>
<body>
<div align="right" style="padding-left: 80%; height: 80px; width: 200px;">
&nbsp;Bem-vindo<c:out value=" ${sessionScope.login}"/>
<a href="http://localhost:8080/Trabalho_Ti_DoomBox/Login.do?method=logout"><img align="right" src="images/logout.gif" alt="Logout" title="Logout" /></a>
<br/>
<font style="text-align: left;">Hora do login: <c:out value="${sessionScope.hora}" /></font>
</div>
<div align="left" style=" border: infobackground; border-bottom-width:5px; border-color: #62C5d6; border-width: 50px; height: 300px; width: 100px; background-color: #32b5d6;">
<br/><br/>
<ul>
<li><a href="#">Exibir</a></li>
<li><a href="#">Buscar</a></li>
</ul>
</div>
</body>
</html>