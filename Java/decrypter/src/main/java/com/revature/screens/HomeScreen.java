package com.revature.screens;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HomeScreen extends Screen {

    public HomeScreen() {
        super("HomeScreen", "/home");
    }
    @Override
    public void render() {
        System.out.println("Welcome to Decrypter!\n");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit application");

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection) {
                case "1":
                    System.out.println("Navigating to login screen");
                    break;
                case "2":
                    System.out.println("Navigating to register screen");
                    break;
                case "3":
                    System.out.println("Exiting application");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
