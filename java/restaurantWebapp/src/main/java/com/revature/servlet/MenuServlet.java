package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.repo.MenuItemRepository;
import com.revature.service.MenuItemService;
import com.revature.util.JwtParser;

public class MenuServlet extends HttpServlet {

    private MenuItemRepository menuRepo = new MenuItemRepository();
    private MenuItemService menuService = new MenuItemService(menuRepo);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();

        JwtParser.checkToken(req);
        if (req.getAttribute("principal") == null) {
            throw new RuntimeException("Unauthorized access to /menu endpoint");
        }

        resp.setHeader("Content-Type", "application/json");
        writer.write(mapper.writeValueAsString(menuService.getAllMenuItems()));
    }
    
}
