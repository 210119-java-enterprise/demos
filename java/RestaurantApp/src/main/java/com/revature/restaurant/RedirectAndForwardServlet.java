package com.revature.restaurant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet hierarchy
 *
 *          Servlet     Serializable        (Interfaces)
 *
 *          GenericServlet  (Abstract Class)
 *
 *          HttpServlet     (Abstract Class)
 *
 *          Custom Servlet
 */

@WebServlet(name = "redirect", urlPatterns = {"/marriott", "/marriott-reservation"})
public class RedirectAndForwardServlet extends HttpServlet {


    //the doget method will redirect the request to a different location. The client is well aware of
    //      where the responder is sending it
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("http://www.marriott.com/");
    }

    //the dopost method will take the request and hand it over to another servlet. We are going to send this
    //      request to the reservation servlet. methods need to match for this.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/reservation").forward(req, resp);

    }
}
