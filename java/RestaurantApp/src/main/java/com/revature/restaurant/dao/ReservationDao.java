package com.revature.restaurant.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.restaurant.pojo.Reservation;

public class ReservationDao {
	
	private List<Reservation> dummyDB = new ArrayList<Reservation>();

	public void createReservation(Reservation res) {
		
		dummyDB.add(res);
		
	}
	
	public List<Reservation> readAll() {
		return dummyDB;
	}
	
	
	
}
