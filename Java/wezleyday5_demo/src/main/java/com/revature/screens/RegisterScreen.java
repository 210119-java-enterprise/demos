package com.revature.screens;

import com.revature.models.AppUser;

import java.io.IOException;

import static com.revature.Decrypter.app;

public class RegisterScreen extends Screen {

    public RegisterScreen () {
        super("RegisterScreen","/register");
    }


    @Override
    public void render() {

        String firstName;
        String lastName;
        String username;
        String password;

        try{
            System.out.println("Sign up for a new account!");
            System.out.print("First name: ");
            firstName = app().getConsole().readLine();
            System.out.print("Last name: ");
            lastName = app().getConsole().readLine();
            System.out.print("Username: ");
            username = app().getConsole().readLine();
            System.out.println("Password: ");
            password = app().getConsole().readLine();

            AppUser appUser = new AppUser(firstName, lastName, username, password);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
