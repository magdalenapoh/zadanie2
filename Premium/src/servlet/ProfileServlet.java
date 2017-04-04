package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AddressDAO;
import data.Address;
import data.User;

public class ProfileServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private HttpSession session;  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		session = request.getSession();	
		User user = (User)session.getAttribute("currentUser");
		AddressDAO addressDao = new AddressDAO();
		List<Address> addresses = addressDao.getUserAddress(user.getId());

		request.setAttribute("username", user.getUsername());
		request.setAttribute("privilege", user.getPrivilege().getDescription());	
		request.setAttribute("uniqueID", user.getId());
		
		request.setAttribute("password", user.getPassword());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("addrList", addresses);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
		dispatcher.forward(request,response);

		
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
