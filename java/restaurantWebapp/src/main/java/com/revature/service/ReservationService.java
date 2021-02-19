package com.revature.service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.revature.pojo.Reservation;
import com.revature.repo.ReservationRepository;

public class ReservationService {

    private ReservationRepository repo;

    public ReservationService(ReservationRepository repo) {
        this.repo = repo;
    }

    public void makeReservation(Reservation newRes) {
        repo.createReservation(newRes);
    }

	public List<Reservation> getAllReservations() {
		return repo.getAll();
	}
    
}
