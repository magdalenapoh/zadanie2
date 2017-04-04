package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import data.User;


public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
	
	public ListServlet() {
		userDao = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String premiumValue;
		
		out.print("<table class='table'> <thead><tr><th>Username</th><th>Premium</th></tr></thead><tbody>");
		
		for(User user : userDao.getUsersFromDB()) {
			
			premiumValue = "NIE";
			
			if(user.getPrivilege().getId() == 2 || user.getPrivilege().getId() == 3) {
				premiumValue ="TAK";
			}
			
			out.print("<tr class='active'><td>"+ user.getUsername() +"</td><td>"+ premiumValue +"</td></tr>");
		}		
		out.print("</tbody></table>");	
	}


	

}

