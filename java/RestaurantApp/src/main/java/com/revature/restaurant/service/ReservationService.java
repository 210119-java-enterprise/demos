package com.revature.restaurant.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.revature.restaurant.dao.ReservationDao;
import com.revature.restaurant.pojo.Reservation;

public class ReservationService {
	
	private ReservationDao dao;
	
	public ReservationService(ReservationDao dao) {
		super();
		this.dao = dao;
	}



	public void makeReservation(Reservation res) {
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy:hh-mm");
		
		//System.out.println(formatter);
		
		//LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
		
		//Reservation reservation = new Reservation();//new Reservation(firstName, lastName, localDateTime);

		//reservation.setFirstName(firstName);
		
		//reservation.setLastName(lastName);
		
		dao.createReservation(res);
		
	}
	
	public List<Reservation> getAllReservations() {
		return dao.readAll();
	}

}
