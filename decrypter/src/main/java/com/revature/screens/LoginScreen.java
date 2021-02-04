package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.models.AppUser;
import com.revature.services.UserService;

import javax.security.sasl.AuthenticationException;

import static com.revature.Decrypter.app;

public class LoginScreen extends Screen {

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

            System.out.println("+---------------------+");
            System.out.println("Please provide your login credentials");
            System.out.print("Username: ");
            username = app().getConsole().readLine();
            System.out.print("Password: ");
            password = app().getConsole().readLine();

            userService.authenticate(username, password);

            if (app().isSessionValid()) {
                System.out.println("[LOG] - Login successful, navigating to dashboard...");
//                app().getRouter().navigate("/dashboard");
            }

        } catch (InvalidRequestException | AuthenticationException e) {
            System.err.println("[INFO] - Invalid login credentials provided!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("[SEVERE] - An unexpected exception occurred");
            System.err.println("[FATAL] - Shutting down application");
            app().setAppRunning(false);
        }
    }

}