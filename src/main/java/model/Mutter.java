package model;
import java.io.Serializable;
public class Mutter implements Serializable{
		
	private String UserName;
	private String text;
	
	private String date;
	
	public Mutter() {};
	
	public Mutter(String userName,String text,String date) {
		this.UserName = userName;
		this.text = text;
		this.date = date;
	}

	public String getUserName() {
		return UserName;
	}

	public String getText() {
		return text;
	}

	public String getDate() {
		return date;
	}

	
	
	
	
}
