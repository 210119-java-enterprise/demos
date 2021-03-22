package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Requirements:
 *      - Send a welcome message to customer +
 *      - Show menu items +
 *      - Book reservations
 *      - Place order
 */
public class RestaurantWelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String userName = req.getParameter("name");
        writer.write("Welcome to this restaurant");
        if (userName != null) {
            writer.write(", " + userName);
        }
    }
    
}
