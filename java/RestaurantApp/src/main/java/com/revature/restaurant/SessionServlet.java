package com.revature.restaurant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.restaurant.pojo.AppUser;
import com.revature.restaurant.pojo.Credentials;
import com.revature.restaurant.service.UserService;
import com.revature.restaurant.util.JwtGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "session", urlPatterns = {"/session"})
public class SessionServlet extends HttpServlet {

    // TODO: try to avoid direct instantiation of service object here
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String ssn = (String) req.getSession().getAttribute("ssn");
        resp.getWriter().write(req.getSession().getId());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter respWriter = resp.getWriter();
        resp.setContentType("application/json");

        try {

            Credentials creds = mapper.readValue(req.getInputStream(), Credentials.class);
            System.out.printf("Attempting to authenticate user, %s, with provided credentials", creds.getUsername());

            AppUser authUser = userService.authenticate(creds.getUsername(), creds.getPassword());
            System.out.println("User succesffuly authenticated!");
            respWriter.write(mapper.writeValueAsString(authUser));

            String token = JwtGenerator.createJwt(authUser);

            Cookie tokenCookie = new Cookie("my-token", token);
            tokenCookie.setHttpOnly(true);
            resp.addCookie(tokenCookie);

//            System.out.printf("Establishing a HTTP session for user, %s", authUser.getUsername());
//            req.getSession().setAttribute("this-user", authUser);


        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
    }
}
