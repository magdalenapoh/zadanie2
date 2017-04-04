<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file = "bootstrap/bootstrap.html"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"  name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<title>Profil uzytkownika</title>
</head>
<body>
<jsp:include page ="menu.jsp" />

<div class="container">
  <h2>Welcome <%= request.getAttribute("username")%>!</h2>
  <p><strong>Note:</strong> Welcome on the profile page. You can view all your information here and may in future also edit them.</p>
  <div class="panel-group" id="accordion">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Password</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse">
        <div class="panel-body">
        
        <%= request.getAttribute("password") %>
        
        </div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">E-mail</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body">
        
        <%= request.getAttribute("email") %>
        
		</div>
      </div>
    </div>
    
    
    
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Reference Unique Identification</a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body">
        
        <%= request.getAttribute("uniqueID") %>
        
		</div>
      </div>
    </div>
    
    
    
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">Status</a>
        </h4>
      </div>
      <div id="collapse4" class="panel-collapse collapse">
        <div class="panel-body">
        
  
        <%= request.getAttribute("privilege") %>
        </div>
      </div>
    </div>
    
    
        <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse5">Addresses</a>
        </h4>
      </div>
      <div id="collapse5" class="panel-collapse collapse in">
        <div class="panel-body">
        
  
       <div class="container-fluid">
			<div class="row">
			<div class="col-md-12">
			 
			<address>
			
			<c:forEach items="${addrList}" var="adr">
			
				<div class="well">
				
				<a href="AddressEditorServlet?param=<c:out value="${adr.getId()}" />" role="button" class="btn btn-xs btn-default">Edit</a>
				<a href="AddressDeleterServlet?param=<c:out value="${adr.getId()}" />" role="button" class="btn btn-xs btn-default">Delete</a>
				
				<br />
				
					<strong><c:out value="${adr.getCity()}"/></strong>, <c:out value="${adr.getZipcode()}" />
					<br />
						<c:out value="${adr.getStreet()}" /> 
						<c:out value="${adr.getHouseNumber()}" />
					<br />
						woj. <c:out value="${adr.getProvince().getName()}" /><br /><br />
 				<span class="label label-info"><c:out value="${adr.getAddressType().getName()}" /></span>
			
				</div>

            </c:forEach>
			

			
			<!-- <strong>Twitter, Inc.</strong><br /> 795 Folsom Ave, Suite 600<br /> San Francisco, CA 94107<br /> <abbr title="Phone">P:</abbr> (123) 456-7890  -->
	
			 <a href="address.jsp" role="button" class="btn btn-block btn-primary btn-xs">Add new address</a>
				 
			</address>
		</div>
	</div>
</div>
</div>
</div>
</div>
</div> 
</div>
</body>
</html>