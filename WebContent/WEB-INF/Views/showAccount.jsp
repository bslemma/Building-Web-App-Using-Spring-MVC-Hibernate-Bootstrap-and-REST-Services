<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="lbl.title"/></title>
</head>
<body>
<h2>BEH: Bank Account Details</h2>
<!--  <p> Account #: ${param.accountNumber}	</p>
<p> Account Holder Name: ${param.accountHolderName}	</p>
<p> Account Balance: ${param.accountBalance}</p>
-->

<p><spring:message code="lbl.accountNumber" />: ${account.accountNumber}	</p>
<p><spring:message code="lbl.accountHolderName" />: ${account.accountHolderName}	</p>
<p><spring:message code="lbl.accountBalance" />: ${account.accountBalance} </p>



</body>
</html>