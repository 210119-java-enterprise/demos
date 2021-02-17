package com.revature.restaurant.util;

import com.revature.restaurant.pojo.AppUser;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtGenerator {

    public static String createJwt(AppUser subject) {

        SignatureAlgorithm sigAlg = SignatureAlgorithm.HS512;
        long now = System.currentTimeMillis();

        JwtBuilder builder = Jwts.builder()
                                .setId(Integer.toString(subject.getId()))
                                .setSubject(subject.getUsername())
                                .setIssuer("revature")
                                .claim("role", subject.getRole())
                                .setExpiration(new Date(now + 300000))
                                .signWith(sigAlg, "super-secret-key");

        return builder.compact();

    }
}
