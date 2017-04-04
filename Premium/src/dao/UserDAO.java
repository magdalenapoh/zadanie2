package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.Privilege;
import data.User;
import parser.SQLUserParser;

public class UserDAO {
	
	private final static String DBURL = "jdbc:mysql://bakemono.pl/servlet";
    private final static String DBUSER = "Santroy";
    private final static String DBPASS = "java";
    private final static String DBDRIVER = "com.mysql.jdbc.Driver";
    
    private Connection connection;
    private Statement statement;
    private String query;
    private SQLUserParser sqlUserParser;
    
    public UserDAO() {
    	
    	sqlUserParser = new SQLUserParser();
    	
        try {
    		
    		Class.forName(DBDRIVER);
    		connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
    		statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e)
		{
        	e.printStackTrace();
		}    	
    	
    }
    
    public void save(User user) {
    	query = sqlUserParser.createSaveQuery(user);
    	
    	try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void changePrivilege(String username, String privilege) {
    	
    	int privilegeId = 0;
    	
    	if(privilege.equals("user")) {
    		privilegeId = 1;
    	} 
    	
    	if(privilege.equals("premiumUser")) {
    		privilegeId = 2;
    	}	
    	
    	if(privilege.equals("admin")) {
    		privilegeId = 3;
    	}

    	query = sqlUserParser.changePrivilegesQuery(username, privilegeId);
    	  	
    	try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
    
    public User getByUsername(String username) {
    	User user = new User();
    	
    	query = sqlUserParser.getByUsernameQuery(username);
    	
    	ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(query);
		
    	while(resultSet.next()) {
    		user.setId(resultSet.getInt("id"));
    		user.setUsername(resultSet.getString("username"));
    		user.setPassword(resultSet.getString("password"));
    		user.setEmail(resultSet.getString("email"));
    		user.setPrivilege(Privilege.values()[resultSet.getInt("privilege")]);
    	}
    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return user; 	
    }
     
    public List<User> getUsersFromDB() {
    	
    	List<User> users = new ArrayList<>();
    	User user;
    	query = sqlUserParser.getAllUsersQuery();
    	
    	try {
    	ResultSet resultSet = statement.executeQuery(query);
    	
			while(resultSet.next()) {
							
				user = new User();
							
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setPrivilege(Privilege.values()[resultSet.getInt("privilege")]);
				
				users.add(user);
			
				
			}
		} 
    	catch (SQLException e) {
			e.printStackTrace();		
		}
    		
		return users;
    	
    }
    
    public boolean validate(String username, String password) {
    	boolean result = false;
    	query = sqlUserParser.checkUserQuery(username, password);
    	
    	try {
			ResultSet resultSet = statement.executeQuery(query);
	        result = resultSet.next();		
		} catch (SQLException e) {
			e.printStackTrace();
		}    	
    	return result;
    }
    
    public boolean validate(String username) {
    	boolean result = false;
    	query = sqlUserParser.getByUsernameQuery(username);

		try {
			ResultSet resultSet = statement.executeQuery(query);
			result = resultSet.next();
		} catch (SQLException e) {

			e.printStackTrace();
		}
   	
    	return result;
    }
}
