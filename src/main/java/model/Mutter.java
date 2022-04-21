package model;
import java.io.Serializable;
public class Mutter implements Serializable{
		
	private String UserName;
	private String text;
	private int age;
	private String date;
	
	public Mutter() {};
	
	public Mutter(String userName,String text,int age,String date) {
		this.UserName = userName;
		this.text = text;
		this.age = age;
		this.date = date;
	}

	public String getUserName() {
		return UserName;
	}

	public String getText() {
		return text;
	}

	public int getAge() {
		return age;
	}

	
	public String getDate() {
		return date;
	}

	
	
	
	
}
