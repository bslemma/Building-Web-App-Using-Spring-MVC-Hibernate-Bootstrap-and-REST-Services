<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BEH Account Holder Details</title>
</head>
<body>
 <div class="container">
 	<%@ include file="header.jsp" %>
 	
 	<div class="row">
 		<div class="col-12">
 			<c:url value="/logout" var="logoutUrl" />
 			<form action="${logoutUrl}" method="post" id="logoutForm">
 				<input type="hidden" name="${_csrf.parameterName}"
 				value="${_csrf.token}" />
 			</form>
 			
 			<script >
 				function formSubmit(){
 					document.getElementById("logoutForm").submit();
 				}
 			</script>
 			
 			<p class="display-5">
 			 Welcome : {username} , <a href="javascript:formSubmit()">Logout</a>
 			</p>
 			
 		</div>
 	</div>
 	
 	<div class="row">
 		<div class="col-12">
 			<a href="<c:url value='/new' />" class="btn btn-lg btn-primary">Add New Account</a>
 		</div>
 	</div>
 	<div class="row">
 		<div class="col-12">
 		<table class="table table-bordered table-hover">
	<thead class="bg-success">
		<tr>
			<th><spring:message code="lbl.accountNumber" /></th>
			<th><spring:message code="lbl.accountHolderName" /></th>
			<th><spring:message code="lbl.accountBalance" /></th>
			<th> &nbsp; </th>
			<th> &nbsp; </th>
		</tr>
	</thead>
		<c:forEach var="account" items="${accounts}">
		    <c:url var="updateLink" value="/edit">
		    	<c:param name="accountNumber" value="${account.accountNumber}}" />
		    </c:url>
		    <c:url var="deleteLink" value="/delete">
		    	<c:param name="accountNumber" value="${account.accountNumber}}" />
		    </c:url>
			<tr>
			<th>${account.accountNumber}</th>
			<th>${account.accountHolderName}</th>
			<th>${account.accountBalance}</th>
			<th> <a href="${updateLink}" class="btn btn-warnning">Edit</a></th>
		    <th> <a href="${deleteLink}" class="btn btn-danger"  onClick="if(!(confirm('Are you sure to delete'))) return false">
		    		Delete</a></th>
		</tr>
		</c:forEach>
	<tbody>
	</tbody>
</table>
 		</div>
 	</div>
 	
 	
 	<%@ include file="footer.jsp" %>
 
 </div>
</body>
</html>