package data;

public enum Province {

	DOLNOSLASKIE(1, "dolnoslaskie"), 
	KUJAWSKOPOMORSKIE(2, "kujawsko-pomorskie"), 
	LUBELSKIE(3, "lubelskie"),
	LUBUSKIE(4, "lubuskie"), 
	LODZKIE(5, "lodzkie"), 
	MALOPOLSKIE(6, "malopolskie"), 
	MAZOWIECKIE(7, "mazowieckie"),
	OPOLSKIE(8, "opolskie"), 
	PODKARPACKIE(9, "podkarpackie"), 
	PODLASKIE(10, "podlaskie"),
	POMORSKIE(11, "pomorskie"),
	SLASKIE(12, "slaskie"),
	SWIETOKRZYSKIE(13, "swietokrzyskie"),
	WARMINSKOMAZURSKIE(14, "warminsko-mazurskie"),
	WIELKOPOLSKIE(15, "wielkopolskie"),
	ZACHODNIOPOMORSKIE(16, "zachodniopomorskie");
	
	private int id;
	private String name;
	
	Province(int id, String name) {
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
