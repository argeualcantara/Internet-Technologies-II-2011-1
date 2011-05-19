<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>

<html:form action="Usuario.do?method=uploadArquivo">
	<table>
		<tr align="right" style="text-align: right;" >
			<td>Descrição</td>
			<td><html:text style="border: ridge; border-color: #000000; border-width: 1px;" property="descricao"></html:text></td>
		</tr>
		<tr>
		<td>Escolha o arquivo</td>
		<td align="right" style="text-align: right;"><html:button property="upload" value="Esclher"/></td>
		</tr>
		<tr>
		<td colspan="2" style="text-align: center;"><html:submit value="Enviar"/></td>
		</tr>
	</table>
</html:form>