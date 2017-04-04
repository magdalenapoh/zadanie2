<%@page import="data.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@include file = "bootstrap/bootstrap.html"  %>
          <%
    		User user = (User) session.getAttribute("currentUser");
			if(user == null && user.getPrivilege().getId() == 0)
			response.sendRedirect("index.jsp"); 
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista uzytkownikow</title>
</head>
<body>
<jsp:include page ="menu.jsp" />
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<div class="container">
						<h2>Users List</h2>
						<p>The list of users already registered on this site with premium annotation.</p>   
						<jsp:include page = "/ListServlet" />
				</div>
							
			</div>
		</div>
	</div>
</div>

</body>
</html>