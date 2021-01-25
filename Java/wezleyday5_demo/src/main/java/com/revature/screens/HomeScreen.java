package com.revature.screens;

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
        System.out.println("3) Exit Application");

        try {
            System.out.print("> ");
            String userSelection = app().getConsole().readLine();

            switch (userSelection) {
                case "1":
                    System.out.println("Navigating to Login Screen.");
                    break;
                case "2":
                    System.out.println("Navigating to Register Screen.");
                    break;
                case "3":
                    System.out.println("Exiting Application");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Shutting down application");
            app().setAppRunning(false);
        }
    }
}
