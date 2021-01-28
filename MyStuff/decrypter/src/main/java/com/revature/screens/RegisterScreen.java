package com.revature.screens;

import com.revature.models.AppUser;

public class RegisterScreen extends Screen{

    public RegisterScreen(){
        super("RegisterScreen","/register");
    }

    @Override
    public void render() {
        String firstName;
        String lastName;
        String username;
        String password;

        try {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n+--------------------------------------+\nRegistration Screen");
            System.out.println("Sign up for a free account");
            System.out.println("First Name: ");
            firstName = app().getConsole.readLine();
            System.out.println("Last Name: ");
            lastName = app().getConsole.readLine();
            System.out.println("Username: ");
            username = app().getConsole.readLine();
            System.out.println("Password: ");
            password = app().getConsole.readLine();

            AppUser newUser =new AppUser(firstName,lastName,username,password);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
