<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to BEH Bank Web Application</title>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp" %>
			<div class="row">
				<div  class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
					<div class="jumbotron">
					 	<h1 class="dispaly-4">Welcome to BEH Bank</h1>
					 	<p class="lead">
					 	  Happines=A Good Bank Account, A Good Cook and Good Digestion - Jean
					 	</p>
					</div>
					<a href="user/new" class="btn btn-lg btn-success">Register Here</a>
					<p><br /> Existing Users: <a href="/user/login">Login Here</a>
				</div>
			</div>
			
			<div class="row">
				<div  class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col-12">
					<div class="card" style="height: 200px">
						<div class="card-header">Online</div>
					
					</div>
				</div>
			</div>
		
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>