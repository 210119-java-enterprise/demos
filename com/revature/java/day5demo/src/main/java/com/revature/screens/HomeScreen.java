package com.revature.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeScreen extends Screen {

    public HomeScreen() {
        super("HomeScreen", "/home");
    }

    @Override
    public void render() {
        System.out.println("Welcome to decrypter.");
        System.out.println("1 - Login");
        System.out.println("2 - Register new user");
        System.out.println("3 - Exit application");

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("> ");
            String userSelection = consoleReader.readLine();
            
            switch (userSelection) {
                case "1":
                    System.out.println("Navigating to login screen");
                    break;
                case "2":
                    System.out.println("Navigating to registration screen");
                    break;
                case "3":
                    System.out.println("Exiting application");
                    break;
                default:
                    System.out.println("Invalid selection: please enter a number 1-3.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
