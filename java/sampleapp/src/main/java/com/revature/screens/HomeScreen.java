package com.revature.screens;

//this is importing the app() method from the SampleApp class
import static com.revature.SampleApp.app;
import com.revature.util.AppState;

public class HomeScreen extends Screen{

    public HomeScreen(){
        super("HomeScreen","/home");
    }

    @Override
    public void render() {

        System.out.println("Welcome to Decrypter");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit Application");

        try {
            System.out.print("> ");
            String userSelection = app().getConsoleReader().readLine();
            switch(userSelection){
                case "1":
                    System.out.println("Navigating to Login Screen");
                    app().getRouter().navigate("/login");
                    break;
                case "2":
                    System.out.println("Navigating to Register Screen");
                    app().getRouter().navigate("/register");
                    break;
                case"3":
                    System.out.println("Exiting application");
                    app().setAppRunning(false);
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Shutting down application due to error");
            app().setAppRunning(false);
        }
    }
}
