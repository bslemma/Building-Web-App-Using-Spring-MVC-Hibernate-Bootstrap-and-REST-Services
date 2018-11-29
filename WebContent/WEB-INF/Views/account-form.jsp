<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="lbl.title" /></title>
<style>
 .error{
 	color:red
 }
</style>
</head>
<body>
<h2>Please fill all the Details</h2>
<form:form method="POST"
  action="saveAccount" modelAttribute="account">
<table>
	<tr>
		<td><spring:message code="lbl.accountNumber"/> </td>
		<td><form:input path="accountNumber" size="30" />
		<form:errors path="accountNumber" cssClass="error" />
		<b><font color="red">${message}</font></b>
		</td>
	</tr> 
	<tr>
		<td><spring:message code="lbl.accountHolderName"/></td>
		<td><form:input path="accountHolderName" size="30" />
		<form:errors path="accountHolderName" cssClass="error" />
		</td>
	</tr>
	<tr>
		<td><spring:message code="lbl.accountBalance"/> </td>
		<td><form:input path="accountBalance" size="30" />
		<form:errors path="accountBalance" cssClass="error" />
		</td>
	</tr> 

	<tr> 
		<td colspan="2" align="center"><input type="Submit" name="btnSubmit" value="Save Account" /></td>
	</tr> 
</table>
</form:form>
</body>
</html>