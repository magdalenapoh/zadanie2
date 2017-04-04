package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressDAO;

public class AddressDeleterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddressDAO addressDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		addressDao = new AddressDAO();	
		int addressId = Integer.parseInt(request.getParameter("param"));
		
		addressDao.removeAddress(addressId);
		
		response.sendRedirect("ProfileServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
