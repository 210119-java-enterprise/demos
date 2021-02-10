package com.revature.screens;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.*;

import static com.revature.Decrypter.*;

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

        try {
            System.out.print("> ");
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
                    break;
                default:
                    System.out.println("Invalid selection!");
                    app().setAppRunning(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            app().setAppRunning(false);
        }
    }
}
