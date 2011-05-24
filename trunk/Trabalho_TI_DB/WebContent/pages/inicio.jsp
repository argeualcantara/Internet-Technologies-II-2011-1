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
list-style-type: none;
}
</style>
<script type="text/javascript" src="js/doombox.js" ></script>
<script type="text/javascript" src="js/jquery.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DoomBox</title>
<link rel="shortcut icon" href="images/favicon.png" type="image/png" />
</head>
<body alink="blue" link="blue" vlink="blue" >

<div align="right" style="padding-left: 80%; height: 80px; width: 200px;">
	Bem-vindo<c:out value=" ${sessionScope.login}"/>
<a href="http://localhost:8080/Trabalho_TI_DB/Login.do?method=logout"><img align="right" border="0" src="images/logout.gif" alt="Logout" title="Logout" /></a>
<br/>
<font style="text-align: left;">Hora do login: <c:out value="${sessionScope.hora}" /></font>
</div>
	<div align="left" style="border: ridge; border-color: #aba9a6; border-width: 5px; height: 200px; width: 100px; background-color: #c1c1c1;">
		<br/><br/>
		<ul>
			<li><a href="http://localhost:8080/Trabalho_TI_DB/Usuario.do?method=exibirArquivos">Exibir</a></li>
			<li><a href="http://localhost:8080/Trabalho_TI_DB/Usuario.do?method=trazer&mostrar=busca">Buscar</a></li>
		</ul>
		<div align="center" style="border: ridge; border-color: #aba9a6; border-width: 5px; background-color: #c1c1c1; position:absolute; top:90px; left:200px; width:500px; height:570px;">
			<c:choose>
				<c:when test="${busca!=null}">
					<jsp:include page="busca.jsp"/>
				</c:when>
				<c:when test="${exibir!=null}">
					<div id="uploadDiv" >
					<div align="left" style="font-size: 12px; border-width:1px; background-color:#FFFFFF; border:thin; border-style:solid; border-color: #000000;">
					<jsp:include page="exibir.jsp"/>
					<br/>
					</div>
					<br/><br/>
					<div style=" width:200px; border: ridge; border-color: #aba9a6; border-width: 5px; background-color: #FFFFFF;" >
					<input type="radio" name="radio" id="radio" value="arquivo" onclick="radioDiv();"/>Arquivo &nbsp;&nbsp;&nbsp;
					<input type="radio" name="radio" id="radio" value="direorio" onclick="radioDiv();"/>Diretório
					</div>
					<br/>
					<div id="arquivoDiv" style="visibility: hidden;">
						<jsp:include page="enviarArquivo.jsp"></jsp:include>
					</div>
					<div id="diretorioDiv" style="visibility: hidden;" >
						<jsp:include page="criarDiretorio.jsp"></jsp:include>
					</div>
					</div>
				</c:when>
			</c:choose>
			<c:if test="${lista!=null}">
				<jsp:include page="listarArquivos.jsp"/>
			</c:if>
		</div>
	</div>
</body>
</html>