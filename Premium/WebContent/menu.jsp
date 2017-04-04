<%@page import="data.Privilege"%>
<%@page import="data.User"%>
<% 
User user;
	if(session.getAttribute("currentUser") == null) {
		user = new User();	
		user.setUsername("Gosc");
		user.setPrivilege(Privilege.GUEST);
		session.setAttribute("currentUser", user);
		user = null;
	}

%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Premium Site</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
 <%
 
 user = (User) session.getAttribute("currentUser");
 
 out.print("<li class='active' role='home' class='active'><a href='index.jsp'>Strona Glowna</a></li>");
 
 if(user.getPrivilege().getId() == 0) {
	 out.print("<li role='login'><a href='login.jsp'>Logowanie</a></li>");
 	 out.print("<li role='registration'><a href='registration.jsp'>Rejestracja</a></li>");
 }
 
 if(user.getPrivilege().getId() != 0) {
	 out.print("<li role='profile'><a href='ProfileServlet'>Profil</a></li>");
	 out.print("<li role='userList'><a href='userlist.jsp'>Lista uzytkownikow</a></li>");
	 out.print("<li role='userList'><a href='LogoutServlet'>Wylogowanie</a></li>");
 }
 
 if(user.getPrivilege().getId() >= 2) {
	 out.print("<li role='premium'><a href='premium.jsp'>Premium</a></li>");
 }
 
 if(user.getPrivilege().getId() == 3) {
	 out.print("<li role='adminPanel'><a href='panel.jsp'>Panel administacyjny</a></li>");
 }
 
 %>

</ul>
</div>
</div>
</nav>
