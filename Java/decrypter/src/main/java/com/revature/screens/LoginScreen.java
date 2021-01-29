package com.revature.screens;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.AppUser;
import com.revature.service.UserService;
import com.revature.util.ConnectionFactory;
import com.revature.util.Session;

import static com.revature.Decrypter.app;

public class LoginScreen extends Screen{

    private UserService userService;

    public LoginScreen(UserService userService) {
        super("LoginScreen", "/login");
        this.userService = userService;
    }

    @Override
    public void render() {
        String username;
        String password;

        try {

            System.out.println("+------------------------------");
            System.out.println("Welcome back! Please input your username and password!");
            System.out.println("Username: ");
            username = app().getConsole().readLine();
            System.out.println("Password: ");
            password = app().getConsole().readLine();

            boolean loggedIn = userService.validLogin(username, password);

            if (!loggedIn) {
                throw new AuthenticationException("There is no account with that username and password combination");
            } else {
                System.out.println("You logged in!");
            }

            // pass our new user to a service class that will validate it and then pass it on to a DAO that will attempt
            // to persist it, we'll get something back to let us know how to navigate from here.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
