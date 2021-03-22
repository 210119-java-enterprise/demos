package com.revature.service;

import com.revature.pojo.AppUser;

public class UserService {
    
    public AppUser authenticate(String username, String password) {
        if (username == null || username.trim().equals("")) {
            throw new RuntimeException("username cannot be empty");
        }
        if (password == null || password.trim().equals("")) {
            throw new RuntimeException("password cannot be empty");
        }

        if (!username.equals("ngamble") && !password.equals("pass")) {
            throw new RuntimeException("No user found with provided credentials");
        }

        return new AppUser(1, "ngamble", "Nate", "Gamble", "*******");
    }
}
