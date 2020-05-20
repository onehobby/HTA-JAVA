package com.sample.vo;

import java.util.Date;

public class User {

	private String Id;
	private String Password;
	private String Name;
	private String Email;
	private int Point;
	private Date registeredDate;
	
	public User() {}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getPoint() {
		return Point;
	}

	public void setPoint(int point) {
		Point = point;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}


	
}
