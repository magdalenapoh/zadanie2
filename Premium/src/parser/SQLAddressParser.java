package parser;

import data.Address;

public class SQLAddressParser {

	private String query = "";
	
	public String createSaveQuery(Address address) {
		
		query = "INSERT INTO address VALUES (NULL, "+ address.getUserId() +", "+ address.getAddressType().getId() +
				","+ address.getProvince().getId() +", '"+ address.getCity() +"', '"+ address.getZipcode() +"', '"+ address.getStreet() + "',"
						+ " '"+ address.getHouseNumber() + "')";	
		return query;
		
	}
	
	public String getByUserId(int id) {
		
		query = "SELECT * FROM address WHERE user_id = "+ id;
		
		return query;
		
	}
	
	public String removeById(int id) {
		
		query = "DELETE FROM address WHERE id = "+ id;
		
		return query;
		
	}
	
	public String getById(int id) {
		
		query = "SELECT * FROM address WHERE id = "+ id;
		
		return query;
		
	}
	
	public String update(Address address) {
		
		query = "UPDATE address SET type = "+ address.getAddressType().getId() +", "
				+ "province = "+ address.getProvince().getId() +", city = '"+ address.getCity() +"', "
						+ "zipcode = '"+ address.getZipcode() +"', street = '"+ address.getStreet() +"', "
								+ "house_number = '"+ address.getHouseNumber() +"' WHERE id = "+ address.getId();
		
		return query;
	}
	
}

