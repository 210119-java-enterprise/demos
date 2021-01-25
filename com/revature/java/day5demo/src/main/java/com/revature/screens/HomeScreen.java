package com.revature.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static com.revature.Decrypter.*;

public class HomeScreen extends Screen {

    public HomeScreen() {
        super("HomeScreen", "/home");
    }

    @Override
    public void render() {
        System.out.println("\nWelcome to Decrypter.\n");
        System.out.println("1 - Login");
        System.out.println("2 - Register new user");
        System.out.println("3 - Exit application");

        try {

            System.out.print("> ");
            String userSelection = app().getConsole().readLine();
            
            switch (userSelection) {
                case "1":
                    System.out.println("Navigating to login screen...\n");
                    // Can do, but creates a new screen each time :(
                    // new LoginScreen().render();
                    break;
                case "2":
                    System.out.println("Navigating to registration screen...\n");
                    break;
                case "3":
                    System.out.println("Exiting application...\n");
                    break;
                default:
                    System.out.println("Invalid selection: please enter a number 1-3.\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Shutting down application...");
            app().setAppRunning(false);
        }

    }
    
}
