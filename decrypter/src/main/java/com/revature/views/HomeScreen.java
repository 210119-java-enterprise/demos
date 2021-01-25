package com.revature.views;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static com.revature.Decrypter.getApp;

public class HomeScreen extends Screen {

    public HomeScreen(){
        super("HomeScreen", "/home");
    }

    @Override
    public void render(){
        System.out.println("Welcome to Decrypter!\n");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit application");


        try{
            System.out.println("> ");
            String userSelection = getApp().getConsole().readLine();
            switch(userSelection)
            {
                case "1":
                    System.out.println("Navigating to Login Screen");
                    break;
                case "2":
                    System.out.println("Navigating to register screen");
                    break;
                case "3":
                    System.out.println("Exiting application");
                    break;
                default:
                    System.out.println("Invalid selection");
            }


        }catch(Exception e)
        {
            e.printStackTrace();
            System.err.println("Error: System shutting down.");
            getApp().setAppRunning(false);
        }

    }
}
