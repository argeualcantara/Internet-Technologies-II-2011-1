<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html:html xhtml="true" lang="true">

<head>
<title></title>
<html:base />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

</head>

<body>

<h1>Importação de Arquivo</h1>




<html:form action="transacaoUpload.do?method=upload"
	enctype="multipart/form-data">

	<table>
		<tr>
			<td><html:file name="uploadForm" property="arquivo"
				styleClass="required" title="Informe o Caminho do Arquivo." /></td>

		</tr>
		<tr>
			<td><html:checkbox property="pais" value="2">Dropbox</html:checkbox></td>
			<td><html:checkbox property="pais" value="7">Pasta 1</html:checkbox></td>
		</tr>
		<tr>
			<td colspan="3">Descricao: <html:text property="descricao"></html:text>
			</td>
		</tr>
		<tr>
			<td><html:submit value="enviar" /></td>
		</tr>
	</table>

</html:form>

</body>

</html:html>
