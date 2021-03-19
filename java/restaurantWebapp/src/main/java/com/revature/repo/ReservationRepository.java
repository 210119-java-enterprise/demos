package com.revature.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Reservation;

public class ReservationRepository {
    private List<Reservation> dummyDB = new ArrayList<>();

    public ReservationRepository() {
        // dummyDB.add(new Reservation("", "", new LocalDate.at()))
    }

    public void createReservation(Reservation res) {
        dummyDB.add(res);
    }

	public List<Reservation> getAll() {
		return dummyDB;
	}
}
