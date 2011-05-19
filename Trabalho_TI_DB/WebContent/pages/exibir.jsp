<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div align="left" style="font-size: 12px; border-width:1px; border:thin; border-style:solid; border-color: #000000;">
<c:forEach items="${arquivos}" var="a">
	<c:choose>
		<c:when test="${a.diretorio==true}">
			<c:choose>
				<c:when test="${a.nome!='Doom Box' }">
					&nbsp;<input type="checkbox" id="<c:out value="${a.id}"/>" /><img src="images/folder.png"/> ${a.nome} <img onclick="excluir(<c:out value="${a.id}"/>);" src="images/excluir.png"/><br/>
				</c:when>
				<c:when test="${a.nome=='Doom Box' }">
					&nbsp;<input type="checkbox" id="<c:out value="${a.id}"/>" /><img src="images/folder.png"/> ${a.nome} <br/>
				</c:when>
			</c:choose>
		</c:when>
		<c:when test="${a.diretorio==false}">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" id="<c:out value="${a.id}"/>"/> 
			<img src="images/file.png"/>
			<a title="Download" href="#"><c:out value="${a.nome}" /></a>
			<img onclick="excluir(<c:out value="${a.id}"/>);" src="images/excluir.png"/><br/>
		</c:when>
	</c:choose>
</c:forEach>
</div>