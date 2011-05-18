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
<div align="left" style=" border:medium; border-color: #85C9FF; height: 300px; width: 100px; background-color: #85B9FF;">
<br/><br/>
<ul compact="compact" >
<li><a href="#">Exibir</a></li>
<li><a href="#">Buscar</a></li>
</ul>
</div>
</body>
</html>