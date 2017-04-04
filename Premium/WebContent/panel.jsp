<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@include file = "bootstrap/bootstrap.html"  %>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panel administratora</title>
</head>
<body>
<jsp:include page ="menu.jsp" />

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron well">
			${Message}
 			<form role="form" ACTION="AdminPanelServlet" METHOD="POST">
 			<h3>Change user status</h3>
  			<div class="form-group">
    			<label for="username">Username</label>
    			<input type="text" class="form-control" name="username">
  			</div>
  			
 			 <label for="privilege">Status</label>
 				<select class="form-control" name="privilege">
    				<option value="user">User</option>
    				<option value="premiumUser">Premium User</option>
   					 <option value="admin">Admin</option>
				</select>
 			 <button type="submit" class="btn btn-default">Change</button>
			</form>
			
			</div>
		</div>
	</div>
</div>

</body>
</html>
