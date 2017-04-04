package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import data.User;
import parser.UserParser;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDao = new UserDAO();
	UserParser uParser = new UserParser();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(!request.getParameter("password").equals(request.getParameter("repeat_password"))) {
			String message = "<div class='alert alert-success alert-dismissable'><h4>Alert!</h4><strong>Warning!</strong> Confirm password must be same as password. </div>";
			request.setAttribute("Message", message);
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}  else 
		{
		
			User user = uParser.parseUserFromRequest(request);
			userDao.save(user);
			response.sendRedirect("index.jsp");
		}
	}

}
