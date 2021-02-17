package com.revature.restaurant.util;

import com.revature.restaurant.pojo.Principal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class JwtParser {

    public static void checkToken(HttpServletRequest req) {


        // Get the HTTP cookie named Authorization
        String token = "";
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("my-token")) {
                token = cookie.getValue();
            }
        }
        try {

            Claims claims = Jwts.parser()
                                .setSigningKey("super-secret-ky")
                                .parseClaimsJws(token)
                                .getBody();

            Principal principal = new Principal();
            principal.setId(claims.getId());
            principal.setUsername(claims.getSubject());
            principal.setRole(claims.get("role", String.class));

            req.setAttribute("principal", principal);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
