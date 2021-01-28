package com.revature.screens;


import static com.revature.Decrypter.app;

public class RegisterScreen extends Screen {


    public RegisterScreen() {
        super("RegisterScreen", "/register");
    }

    @Override
    public void render() {

        String firstName;
        String lastName;
        String userName;
        String passWord;

        System.out.println("Sign up for a new account!");
        System.out.println("First name: ");
        firstName = app().getConsole().readLine();


    }



}
