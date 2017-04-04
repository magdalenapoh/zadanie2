
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file = "bootstrap/bootstrap.html"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Strona rejestracyjna</title>
</head>
<body>

<jsp:include page ="menu.jsp" />

  
  <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		<div class="jumbotron">
		  ${Message}
			<form role="form" action="RegisterServlet" method="POST">
			
			
				<div class="form-group"> 
					<label for="username">
						Username
					</label>
					<input class="form-control" name="username" type="text" required/>
				</div>
				<div class="form-group">				 
					<label for="password">
						Password
					</label>
					<input class="form-control" name="password" type="password" required/>
				</div>
				
				<div class="form-group">				 
					<label for="repeat_password">
						Confirm Password
					</label>
					<input class="form-control" name="repeat_password" type="password" required/>
				</div>
				
				
				<div class="form-group">			 
					<label for="email">
						E-mail
					</label>
					<input class="form-control" name="email" type="email" required/>
				</div>
							
				<button type="submit" class="btn btn-default">
					Submit
				</button>
			</form>
		</div>
		</div>
	</div>
</div>

</body>
</html>