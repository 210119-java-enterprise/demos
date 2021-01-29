package com.revature.screens;

import com.revature.services.UserService;
import static com.revature.Decrypter.app;

import com.revature.models.AppUser;

public class LoginScreen extends Screen {

    String username, password;
    private UserService userService;

    public LoginScreen(UserService userService) {
        super("LoginScreen", "/login");
        this.userService = userService;
    }

    @Override
    public void render() {
        System.out.println("Made it to Login screen!");
        try {
            System.out.println("Login screen works");
            System.out.println("+---------------------------+");
            System.out.println("Please login:");
            System.out.print("Username:\t");
            username = app().getConsole().readLine();
            System.out.println("\nPassword:\t");
            password = app().getConsole().readLine();

            AppUser user = userService.login(username, password);
            
            if (user != null) {
                System.out.println("You have been logged in!");
            } else {
                // app().getRouter().navigate("/register");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
