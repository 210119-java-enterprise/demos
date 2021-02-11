package com.revature.screens;

import com.revature.models.AppUser;
import com.revature.services.UserService;

import static com.revature.Decrypter.app;

public class RegisterScreen extends Screen {

    private UserService userService;

<<<<<<< HEAD
    public RegisterScreen(UserService userService) {
=======
    public RegisterScreen() {
>>>>>>> 6be55055a9ff40bbdec738bda1bb167169288799
        super("RegisterScreen", "/register");
        this.userService = userService;
    }

    @Override
    public void render() {

        String firstName;
        String lastName;
        String username;
        String password;

        try {

            System.out.println("+---------------------+");
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

            userService.register(newUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
