<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:forEach var="a" items="${arquivos}">
		<c:choose>
		<c:when test="${a.diretorio==true}">
			<c:choose>
				<c:when test="${a.id!=1}">
				<c:if test="${a.pai!=1 }">
					<c:forEach begin="0"  end="${espaco}" >
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:forEach>
					</c:if>
					<c:if test="${a.pai==1 }">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
					<c:set value="${espaco+1 }" scope="request" var="espaco"/>
				<input type="checkbox" id="pais" name="pais" value="<c:out value="${a.id}"/>" />
				<img src="images/folder.png"/>
				<c:out value="${a.nome}"/> 
				<img onclick="excluir(<c:out value="${a.id}"/>);" src="images/excluir.png"/> 
				<br/>
					
				</c:when>
				<c:when test="${a.id==1}">
				<c:set value="0" scope="request" var="espaco"/>
				<input type="checkbox" id="pais" name="pais" value="<c:out value="${a.id}"/>" />
					<img src="images/folder.png"/> <c:out value="${a.nome}"/><br/>
				</c:when>
			</c:choose>
		</c:when>
		<c:when test="${a.diretorio==false}">
		<c:if test="${a.pai==1}">
				<c:set value="${0}" scope="request" var="espaco"/>
			</c:if>
			<c:forEach begin="0"  end="${espaco}" >
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</c:forEach>
			
			<input type="checkbox" id="pais" name="pais" value="<c:out value="${a.id}"/>" />
			<img src="images/file.png"/>
			<a title="Download" href="#"><c:out value="${a.nome}" /></a>
			<img onclick="excluir(<c:out value="${a.id}"/>);" src="images/excluir.png"/><br/>
		</c:when>
	</c:choose>
  		<c:if test="${!empty a.files}">
  			<c:set var="arquivos" value="${a.files}" scope="request"/>
  			
  			<jsp:include page="exibir.jsp"/>
  		</c:if>
</c:forEach> 

