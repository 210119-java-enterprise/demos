package com.revature.restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.spec.ECField;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.revature.restaurant.dao.ReservationDao;
import com.revature.restaurant.pojo.Reservation;
import com.revature.restaurant.service.ReservationService;

public class ReservationServlet extends HttpServlet {

	ReservationService service = new ReservationService(new ReservationDao());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BufferedReader reader = req.getReader();

		String line = "";

		ObjectMapper mapper = new ObjectMapper();

		mapper.registerModule(new JSR310Module());

		String json = "";
//		line = reader.readLine();
		while((line = reader.readLine()) != null){
			json += line;
		}
		Reservation res = null;
		res = mapper.readValue(json, Reservation.class);
//		try {
//			res = mapper.readValue(json, Reservation.class);
//		} catch (Exception e){
//			resp.getWriter().write("put in better json, dude");
//		}
		System.out.println(res);

		service.makeReservation(res);

		resp.getWriter().write("we did it, I think there really doesnt seem to be any checking");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String results = "";

		results = service.getAllReservations().toString();


		//PrintWriter writer = resp.getWriter();
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.writeValueAsString(results);

	}

}
