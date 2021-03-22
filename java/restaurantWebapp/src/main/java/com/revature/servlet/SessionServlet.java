package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.AppUser;
import com.revature.pojo.Credentials;
import com.revature.service.UserService;
import com.revature.util.JwtGenerator;

@WebServlet(name = "session", urlPatterns = { "/session" })
public class SessionServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // can use getSession(false) to ensure that it doesn't create a new session except through post
        resp.getWriter().write(req.getSession().getId());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Sessions are associated with a specific application (Chrome, Brave, Postman, etc.)
        HttpSession session = req.getSession();

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try {
            Credentials creds = mapper.readValue(req.getInputStream(), Credentials.class);
            System.out.println("Attempting to authenticate user with provided credentials: " +
                creds.getUsername() + "\t" + creds.getPassword());

            AppUser user = service.authenticate(creds.getUsername(), creds.getPassword());
            System.out.println("User successfully authenticated");
            writer.write(mapper.writeValueAsString(user));

            // System.out.println("Establishing a HTTP session for user: " + user.getUsername());
            // req.getSession().setAttribute("this-user", user);
            String token = JwtGenerator.createJwt(user);
            Cookie tokenCookie = new Cookie("token", token);
            tokenCookie.setHttpOnly(true);
            resp.addCookie(tokenCookie);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
