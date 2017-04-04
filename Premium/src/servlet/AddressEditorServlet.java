package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressDAO;
import data.Address;
import parser.AddressParser;

public class AddressEditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddressDAO addressDao;
	Address address;
	AddressParser addressParser;
	int addressId;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		addressDao = new AddressDAO();
		address = new Address();
		
		addressId = Integer.parseInt(request.getParameter("param"));
		
		address = addressDao.getById(addressId);
		
		request.setAttribute("type", address.getAddressType().name());
		request.setAttribute("province", address.getProvince().name());
		request.setAttribute("city", address.getCity());
		request.setAttribute("zipcode", address.getZipcode());
		request.setAttribute("street", address.getStreet());
		request.setAttribute("houseNumber", address.getHouseNumber());
		
		request.getRequestDispatcher("addresseditor.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addressDao = new AddressDAO();
		addressParser = new AddressParser();
			
		Address address = addressParser.parseAddressFromRequest(request);
		address.setId(addressId);
		addressDao.update(address);
		response.sendRedirect("ProfileServlet");
		
		
	}

}
