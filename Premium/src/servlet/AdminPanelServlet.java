package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

public class AdminPanelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDao;
	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		userDao = new UserDAO();
		String username = request.getParameter("username");
		String privilege = request.getParameter("privilege");
		
		if(!userDao.validate(username)) {
			String message = "<div class='alert alert-success alert-dismissable'><h4>Alert!</h4><strong>Warning!</strong> User not found. </div>";
			request.setAttribute("Message", message);
			request.getRequestDispatcher("panel.jsp").forward(request, response);
		} else 
		{			
			userDao.changePrivilege(username, privilege);			
			response.sendRedirect("panel.jsp");
		}
	}

}
