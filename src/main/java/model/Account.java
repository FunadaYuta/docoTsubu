package model;

public class Account {
	
	private String name;
	private String pass;
	private int age;
	
	public Account(String name,String pass,int age) {
		this.name = name;
		this.pass = pass;
		this.age = age;
	}
	
	public Account(String name,String pass) {
		this.name = name;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

	public int getAge() {
		return age;
	}
	

}
