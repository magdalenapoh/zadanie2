package data;

public enum AddressType {

	HOME(1,"Zakwaterowanie"), MAILING(2,"Korespondencyjny"), BUSINESS(3,"Biznesowy");
	
	private int id;
	private String name;

	AddressType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
