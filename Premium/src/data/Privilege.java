package data;

public enum Privilege {

	GUEST(0,"Gosc"), USER(1,"Uzytkownik"), PREMIUM_USER(2,"Uzytkownik Premium"), ADMIN(3, "Administrator");
	
	private int id;
	private String description;	
	
	Privilege(int id, String desc) {
		this.id = id;
		this.description = desc;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}		
	
	
	
}
