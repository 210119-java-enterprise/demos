package com.revature.restaurant.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
	
	private String firstName;
	
	private String lastName;
	
	private LocalDateTime date;

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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Reservation(String firstName, String lastName, LocalDateTime date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
	}

	public Reservation() {
		super();
	}

	@Override
	public String toString() {
		return "Reservation [firstName=" + firstName + ", lastName=" + lastName + ", date=" + date + "]";
	}
	
}
