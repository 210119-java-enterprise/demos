package com.revature.restaurant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Requirments:
 *  - Send a welcome message to customer +
 * 	- Show Menu Items +
 *  - Book Reseravations 
 *  - Place orders
 */

public class RestaurantWelcomeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		String name = req.getParameter("name");
		
		PrintWriter writer = resp.getWriter();
		writer.write("Welcome " + name + " to this Restaurant");
		
	}
	

}
