package com.revature.screens;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HomeScreen extends Screen {

    public HomeScreen() {
        super("HomeScreen", "/home");
    }

    @Override
    public void render() {
        System.out.println("Welcome to Decrypter BY ERIC\n");
        System.out.println("1) login");
        System.out.println("2) login");
        System.out.println("3) Exit application");

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("> ");
            String userSelection = consoleReader.readLine();
            switch (userSelection) {
                case "1":
                    System.out.println("Navigating to login screen");
                    break;
                case "2":
                    System.out.println("Navigating to registration screen");
                    break;
                case "3":
                    System.out.println("Exiting Application");
                    break;
                default:
                    System.out.println("Invalid Exception");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
