package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.pojo.Reservation;
import com.revature.repo.ReservationRepository;
import com.revature.service.ReservationService;

public class ReservationServlet extends HttpServlet {

    private ReservationService service = new ReservationService(new ReservationRepository());

    // Can use a try/catch block to catch exceptions and do stuff, or add an error-page in web.xml
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // try {
            BufferedReader reader = req.getReader();
            
            ObjectMapper mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
            Reservation newReservation = mapper.readValue(reader, Reservation.class);
            service.makeReservation(newReservation);
        // } catch (Exception e) {
        //     resp.setStatus(500);
        //     resp.getWriter().write("Put in better JSON (probably)");
        // }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JSR310Module());


        resp.setHeader("Content-Type", "application/json");
        writer.write(mapper.writeValueAsString(service.getAllReservations()));

    }

    
    
}
