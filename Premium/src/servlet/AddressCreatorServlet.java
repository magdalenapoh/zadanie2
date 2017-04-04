package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressDAO;
import data.Address;
import parser.AddressParser;


public class AddressCreatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddressDAO addressDao = new AddressDAO();
	AddressParser addressParser = new AddressParser();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		Address address = addressParser.parseAddressFromRequest(request);
		addressDao.save(address);
		response.sendRedirect("ProfileServlet");

	}

}
