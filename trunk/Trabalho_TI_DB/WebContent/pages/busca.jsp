<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:form action="Usuario.do?method=buscarArquivos">
<div style="border: ridge; border-color: #aba9a6; border-width: 5px; background-color: #FFFFFF; position:absolute; left:57px; top:50px;">
<table>
<tr>
<td>Nome do arquivo ou pasta</td>
<td><html:text property="nome" style="border: ridge; border-color: #000000; border-width: 1px;" /> <html:submit value="OK" /></td>
</tr>
</table>
</div>
</html:form>