package com.onemount.dungtran8.models;

public class Member {
	String firstName;
	String lastName;
	String phone;
	String email;
	String password;
	
	public Member() {
		this.firstName = "Tran";
		this.lastName = "Dung";
		this.phone = "0987464646";
		this.email = "dungttt112X1@gmail.com";
		this.password = "Dung12345@!";
	}
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
