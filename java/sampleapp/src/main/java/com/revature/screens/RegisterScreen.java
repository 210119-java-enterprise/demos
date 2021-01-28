package com.revature.screens;

import com.revature.models.AppUser;

import static com.revature.SampleApp.app;

public class RegisterScreen extends Screen{

    public RegisterScreen(){
        super("RegisterScreen", "/register");
    }

    @Override
    public void render() {

        String firstName;
        String lastName;
        String username;
        String password;
        try {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n+--------------------+");
            System.out.println("Sign up for a new account!");
            System.out.print("First Name:");
            firstName = app().getConsoleReader().readLine();
            System.out.print("Last Name: ");
            lastName = app().getConsoleReader().readLine();
            System.out.print("Username: ");
            username = app().getConsoleReader().readLine();
            System.out.print("Password: ");
            password = app().getConsoleReader().readLine();

            AppUser newUser = new AppUser(firstName,lastName,username,password);

            //pass new user to a service class to validate
            //then pass to dao to attempt persist it
            //navigate from here
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
