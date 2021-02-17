package com.revature.restaurant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.restaurant.dao.MenuItemDao;
import com.revature.restaurant.service.MenuItemService;
import com.revature.restaurant.util.JwtParser;

public class MenuServlet extends HttpServlet {
	
	private MenuItemService menuItemService = 
			new MenuItemService(new MenuItemDao());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		HttpSession session = req.getSession(false);
//		if (session == null) {
//			// TODO: replace with a AuthorizationException
//			throw new RuntimeException("Unauthorized access to endpoint /menu!");
//		}
		JwtParser.checkToken(req);
		if (req.getAttribute("principal") == null) {
			throw new RuntimeException("Unauthorized access to endpoint /menu!");
		}
		
		String cookies = "this is my cookie";
		
//		resp.addCookie(new Cookie("my-awesome-cookie", cookies));
		
		resp.setHeader("Content-Type", "application/json");
		
		String results = "";
		
		ObjectMapper mapper = new ObjectMapper();
		
		results = mapper.writeValueAsString(menuItemService.getAllMenuItems());
		
		PrintWriter writer = resp.getWriter();
		writer.write(results);
		
	}

}
