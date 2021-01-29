package com.revature.screens;

import java.io.IOException;
import java.io.InputStreamReader;
import static com.revature.Decrypter.*;
public class HomeScreen extends Screen {

    public HomeScreen(){
        super("HomeScreen", "/home");
    }
    @Override
    public void render(){
        System.out.println("welcome to Decrypter!\n");
        System.out.println("1) login");
        System.out.println("2) Register");
        System.out.println("3) exit application");


        try {
            System.out.print("> ");
            String userSelection = app().getConsole().readLine();

            switch (userSelection){
                case "1":
                    System.out.println("Navigating to login screen");
                    app().getRouter().navigate("/login");
                    break;
                case "2" :
                    System.out.println("Navigating to register screen");
                    app().getRouter().navigate("/register");

                    break;
                case "3" :
                    System.out.println("Exiting selection");
                    app().getRouter().navigate("/");

                    break;
                default:
                    System.out.println("Invalid selection");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Shutting down application");
            app().setAppRunning(false);
        }



    }
}
