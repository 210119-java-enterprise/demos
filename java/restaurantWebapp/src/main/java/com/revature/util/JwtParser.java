package com.revature.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.revature.pojo.Principal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtParser {

    public static void checkToken(HttpServletRequest req) {
        // get HTTP cookie named authorization
        String token = "";
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
            }
        }

        try {
            // automatically decrypts
            Claims claims = Jwts.parser()
                                .setSigningKey("super-secret-key")
                                .parseClaimsJws(token)
                                .getBody();
            Principal principal = new Principal();
            principal.setId(Integer.parseInt(claims.getId()));  
            principal.setUsername(claims.getSubject());
            principal.setFirstName(claims.get("firstName", String.class));

            req.setAttribute("principal", principal);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
