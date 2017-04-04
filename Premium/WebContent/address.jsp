<%@page import="data.Province"%>
<%@page import="data.AddressType"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file = "bootstrap/bootstrap.html"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dodaj adres</title>
</head>
<body>

<jsp:include page ="menu.jsp" />

  
  <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		<div class="jumbotron">
			<form role="form" action="AddressCreatorServlet" method="POST">
				<div class="form-group"> 
					<label for="addressType">
						Typ adresu
					</label>
						<select class="form-control" name="addressType">				
   							<%
   								AddressType addressType;
   					
 								for(AddressType value: AddressType.values())
   								out.print("<option value='"+ value.name() + "'>"+ value.getName() +"</option>");
   							%>	   							
						</select>
				</div>
				
				<div class="form-group"> 
					<label for="province">
						Wojewodztwo
					</label>
						<select class="form-control" name="province">				
   							<%
   								Province province;
   					
 								for(Province value: Province.values())
   								out.print("<option value='"+ value.name() + "'>"+ value.getName() +"</option>");
   							%>	   							
						</select>
				</div>
				
				<div class="form-group"> 
					<label for="city">
						Miasto
					</label>
					<input class="form-control" name="city" type="text" required/>
				</div>
				
				<div class="form-group"> 
					<label for="zipcode">
						Kod pocztowy
					</label>
					<input class="form-control" name="zipcode" type="text" required/>
				</div>
				
				<div class="form-group"> 
					<label for="street">
						Ulica
					</label>
					<input class="form-control" name="street" type="text" required/>
				</div>
				
				<div class="form-group"> 
					<label for="houseNumber">
						Nr domu / Nr mieszkania
					</label>
					<input class="form-control" name="houseNumber" type="text" required/>
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