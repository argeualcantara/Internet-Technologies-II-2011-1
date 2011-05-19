<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div style="padding-top: 105px;">
<table cellpadding="2" cellspacing="2" border="1">
	<tr style="background-color: #3879da; color: white;">
		<td>Nome</td>
		<td>Descrição</td>
		<td>Tipo</td>
		<td>Data</td>
		<td>Tamanho</td>
	</tr>
	<c:forEach items="${arquivos}" var="a" >
		<tr style="background-color: white;" >
			<c:if test="${a.diretorio==false}">
			<td><a title="Download" href="#"><c:out value="${a.nome}" /></a></td>
			<td><c:out value="${a.descricao}" /></td>
			<td>Arquivo</td>
			<td><c:out value="${a.data}" /></td>
			<td><c:out value="${a.bytes / 1024} kb" /></td>
			</c:if>
			<c:if test="${a.diretorio==true}">
			<td><c:out value="${a.nome}" /></td>
			<td><c:out value="${a.descricao}" /></td>
			<td>Diretório</td>
			<td>--</td>
			<td>--</td>
			</c:if>
		</tr>
	</c:forEach>
</table>
</div>