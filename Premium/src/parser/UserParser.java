package parser;

import javax.servlet.http.HttpServletRequest;

import data.User;

public class UserParser {
	
	public User parseUserFromRequest(HttpServletRequest request) {
		
		User user = new User();
		
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
				
		return user;
		
	}

}
