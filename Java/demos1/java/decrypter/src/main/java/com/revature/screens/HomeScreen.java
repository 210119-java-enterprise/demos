package com.revature.screens;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.revature.Decrypter.app;

public class HomeScreen extends Screen {

    public HomeScreen() {
        super("HomeScreen", "/home");
    }

    @Override
    public void render() {
        System.out.println("Welcome to Decrypter BY ERIC\n");
        System.out.println("1) Login");
        System.out.println("2) Registration");
        System.out.println("3) Exit application");


        try {
            System.out.println("> ");
            String userSelection = app().getConsole().readLine();
            switch (userSelection) {
                case "1":
                    System.out.println("Navigating to login screen");
                    app().getRouter().navigate("/login");
                    break;
                case "2":
                    System.out.println("Navigating to register screen");
                    app().getRouter().navigate("/register");
                    break;
                case "3":
                    System.out.println("Exiting application");
                    app().setAppRunning(false);
                    break;
                default:
                    System.out.println("Invalid Exception");
            }
        } catch (Exception e) {
            //exception here likely means console closed
            e.printStackTrace();
            System.err.println("Shutting down application");
            app().setAppRunning(false);
        }

    }
}
