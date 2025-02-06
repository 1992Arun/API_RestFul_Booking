package org.auth;

public class Auth {
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
