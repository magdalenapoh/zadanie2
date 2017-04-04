package parser;

import javax.servlet.http.HttpServletRequest;

import data.Address;
import data.AddressType;
import data.Province;
import data.User;


public class AddressParser {
	
	public Address parseAddressFromRequest(HttpServletRequest request) {
		
		Address address = new Address();
		
		address.setUserId(((User)request.getSession().getAttribute("currentUser")).getId());	
		address.setAddressType(AddressType.valueOf(request.getParameter("addressType")));
		address.setProvince(Province.valueOf(request.getParameter("province")));
		address.setCity(request.getParameter("city"));
		address.setZipcode(request.getParameter("zipcode"));
		address.setStreet(request.getParameter("street"));
		address.setHouseNumber(request.getParameter("houseNumber"));
				
		return address;
		
	}

}
