package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "redirect", urlPatterns = { "/redirect" })
public class RedirectAndForwardServlet extends HttpServlet {

    // doGet redirects user to different url
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("http://www.marriott.com");
    }

    // doPost forwards request to /reservation
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/reservation").forward(req, resp);
        // Anything else in here you do with the response is overwritten by
        // the response from the forwarded request
    }

    

    
    
}
