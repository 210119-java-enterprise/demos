package com.revature.restaurant.service;

import com.revature.restaurant.pojo.AppUser;

public class UserService {

    public AppUser authenticate(String username, String password) {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            // TODO: replace with InvalidRequestException
            throw new RuntimeException("Invalid credentials provided! Contains null or empty strings");
        }

        if (!username.equals("wsingleton") && !password.equals("password")) {
            // TODO: replace with AuthenticationException
            throw new RuntimeException("No user found with the provided credentials!");
        }

        return new AppUser(1, "wsingleton", "********", "Wezley", "Singleton", "ADMIN");

    }

}
