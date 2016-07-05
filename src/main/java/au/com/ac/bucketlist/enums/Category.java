package au.com.ac.bucketlist.enums;

public enum Category {
	
	TRAVEL("Travel"), NEW_SKILL("New Skill"), HELTH("Helth"), SPORT("Sport");
	
	public String value;
	
	 private Category(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
