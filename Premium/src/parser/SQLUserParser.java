package parser;

import data.User;

public class SQLUserParser {

	private String query = "";
	
	public String createSaveQuery(User user) {
		
		query = "INSERT INTO user(username, password, email, privilege) VALUES('" + user.getUsername() + "', '"+ user.getPassword()+"','" + user.getEmail() + "', 1)";	
		return query;
		
	}
	
	public String getAllUsersQuery() {	
		query = "SELECT * FROM user";
		return query;
	}
	
	public String changePrivilegesQuery(String username, int privilegeId) {
		query = "UPDATE user SET privilege = " + privilegeId + " where username = '"+ username + "'";
		return query;
	}
	
	public String getByUsernameQuery(String username) {
		query = "SELECT * FROM user WHERE username = '"+ username +"'";
		return query;
	}
	
	public String checkUserQuery(String username, String password) {
		query = "SELECT * FROM user WHERE username = '"+ username +"' AND password = '"+password+"'";
		return query;
	}

}
