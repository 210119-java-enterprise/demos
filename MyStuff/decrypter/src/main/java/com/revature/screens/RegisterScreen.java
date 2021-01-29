package com.revature.screens;

import com.revature.models.AppUser;
import com.revature.services.UserService;

import static com.revature.Decrypter.app;

public class RegisterScreen extends Screen {

    private UserService userService;

    public RegisterScreen() {
        super("RegisterScreen", "/register");
        this.usersService
    }

    @Override
    public void render() {

        String firstName;
        String lastName;
        String username;
        String password;

        try {

            System.out.println("\n\n\n\n\n\n\n\n\n\n+---------------------+");
            System.out.println("Sign up for a new account!");
            System.out.print("First name: ");
            firstName = app().getConsole().readLine();
            System.out.print("Last name: ");
            lastName = app().getConsole().readLine();
            System.out.print("Username: ");
            username = app().getConsole().readLine();
            System.out.print("Password: ");
            password = app().getConsole().readLine();

            AppUser newUser = new AppUser(firstName, lastName, username, password);

            // pass our new user to a service class that will validate it and then pass it on
            // to a DAO that will attempt to persist it, we'll get something back to let us
            // know how to navigate from here.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
