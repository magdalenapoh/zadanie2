package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.Address;
import data.AddressType;
import data.Province;
import parser.SQLAddressParser;

public class AddressDAO {

	private final static String DBURL = "jdbc:mysql://bakemono.pl/servlet";
    private final static String DBUSER = "Santroy";
    private final static String DBPASS = "java";
    private final static String DBDRIVER = "com.mysql.jdbc.Driver";
    
    private Connection connection;
    private Statement statement;
    private String query;
    private SQLAddressParser sqlAddressParser;
    
    public AddressDAO() {
    	
    	sqlAddressParser = new SQLAddressParser();
    	
        try {
    		
    		Class.forName(DBDRIVER);
    		connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
    		statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e)
		{
        	e.printStackTrace();
		}    	
    	
    }
    
    
    public void save(Address address) {
    	query = sqlAddressParser.createSaveQuery(address);
    	
    	try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
    public List<Address> getUserAddress(int userId) {
    	List<Address> addresses = new ArrayList<Address>();
    	Address address;
    	query = sqlAddressParser.getByUserId(userId);
    	
    	try {
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				address = new Address();
				
				address.setId(resultSet.getInt("id"));
				address.setAddressType(AddressType.values()[resultSet.getInt("type") - 1]);
				address.setProvince(Province.values()[resultSet.getInt("province") - 1]);
				address.setCity(resultSet.getString("city"));
				address.setZipcode(resultSet.getString("zipcode"));
				address.setStreet(resultSet.getString("street"));
				address.setHouseNumber(resultSet.getString("house_number"));
				
				addresses.add(address);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return addresses;
    	
    }
    
    public void removeAddress(int id) {
    	
    	query = sqlAddressParser.removeById(id);
    	
    	try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public Address getById(int id) {
    	
    	Address address = new Address();
    	
    	query = sqlAddressParser.getById(id);
    	
    	ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(query);
		
    	while(resultSet.next()) {
    		
			address.setId(resultSet.getInt("id"));
			address.setAddressType(AddressType.values()[resultSet.getInt("type") - 1]);
			address.setProvince(Province.values()[resultSet.getInt("province") - 1]);
			address.setCity(resultSet.getString("city"));
			address.setZipcode(resultSet.getString("zipcode"));
			address.setStreet(resultSet.getString("street"));
			address.setHouseNumber(resultSet.getString("house_number"));
    		
    	}
    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return address; 	
    }
    
    public void update(Address address) {
    	
    	query = sqlAddressParser.update(address);
    	
    	try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
	
}
