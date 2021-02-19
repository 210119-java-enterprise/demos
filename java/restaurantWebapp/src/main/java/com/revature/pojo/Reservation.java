package com.revature.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private String firstName;
    private String lastName;
    private LocalDateTime reservationTime;

    public Reservation() {

    }

    public Reservation(String firstName, String lastName, LocalDateTime reservationTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.reservationTime = reservationTime;
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

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    
}
