package com.onemount.dungtran8.models;

public class User {
	private String username;
	private String password;

	public User() {
		this.username = "dungttt.12345@gmail.com";
		this.password = "Dung12345@";
	}

	public User(String username) {
		this.username = username;
		this.password = "";
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
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

}
