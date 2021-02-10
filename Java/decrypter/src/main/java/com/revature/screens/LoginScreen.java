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

            // Original way to check, uses a boolean check method to see if it is a valid user.
            //boolean loggedIn = userService.validLogin(username, password);

            // New way, uses the overhead session class to see if we are in a valid session.
            userService.authenticate(username, password);

            if (app().isSessionValid()) {
                System.out.println("[LOG] - Login successful, navigating to dashboard...");
//               app().getRouter().navigate("/dashboard");
            }

            // pass our new user to a service class that will validate it and then pass it on to a DAO that will attempt
            // to persist it, we'll get something back to let us know how to navigate from here.

        } catch (InvalidRequestException | AuthenticationException e) {
            System.err.println("[INFO] - Invalid login credentials provided!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("[SEVERE] - An unexpected exception occured");
            System.err.println("[FATAL] - Shutting down the application");
            app().setAppRunning(false);
        }
    }
}
