package Linkcode.shop.login.model;

public class Registeration {
	String name;
	String Email;
	int mobileno;
	String username;
	String password;
	String Repass;
	
	public Registeration(String name, String email, int mobileno, String username, String password, String repass) {
		super();
		this.name = name;
		Email = email;
		this.mobileno = mobileno;
		this.username = username;
		this.password = password;
		Repass = repass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getMobileno() {
		return mobileno;
	}
	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepass() {
		return Repass;
	}
	public void setRepass(String repass) {
		Repass = repass;
	}
	
	

}
