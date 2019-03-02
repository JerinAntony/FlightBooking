package com.chainsys.flightbooking.model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Passangers {

	private int id;
	private String name;
	private String email;
	private long phonenumber;
	private LocalDate father_DateOfBirth;
	private String username;
	private String password;
	private Timestamp created_date;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public LocalDate getFather_DateOfBirth() {
		return father_DateOfBirth;
	}

	public void setFather_DateOfBirth(LocalDate father_DateOfBirth) {
		this.father_DateOfBirth = father_DateOfBirth;
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

	public Timestamp getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "Passangers [id=" + id + ", name=" + name + ", email=" + email
				+ ", phonenumber=" + phonenumber + ", father_DateOfBirth="
				+ father_DateOfBirth + ", username=" + username + ", password="
				+ password + ", created_date=" + created_date + "]";
	}

}
