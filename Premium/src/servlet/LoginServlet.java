package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import data.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
	private User user;
	private HttpSession session;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		userDao = new UserDAO();		
			
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		
		if(userDao.validate(username, password)) {
			user = userDao.getByUsername(username);
			session.setAttribute("currentUser", user);
			response.sendRedirect("ProfileServlet");	
		} else {
			
			request.setAttribute("Message", "Nieprawidlowe dane!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
				
		}
	}

}
