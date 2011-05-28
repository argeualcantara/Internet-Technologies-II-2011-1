<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>



	<table>
		<tr>
			<td><html:file name="uploadForm" property="arquivo"
				styleClass="required" title="Informe o Caminho do Arquivo." /></td>

		</tr>
		<tr>
			<td colspan="3">Descricao: <html:text property="descricao"></html:text>
			</td>
		</tr>
		<tr>
			<td><html:submit value="enviar" /></td>
		</tr>
	</table>


