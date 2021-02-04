package com.revature.screens;
import static com.revature.BankingApp.*;


//Home Screen of the application, should be able to login/register/exit aplication
public class HomeScreen extends Screen{


    public HomeScreen(){
        super("HomeScreen","/home");
    }

    //render that
    @Override
    public void render() {
        System.out.println("welcome to the Banking App!");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit application");

        System.out.print("> ");


        try {
            String selection = app().getConsole().readLine();

            switch(selection){
                case "1":
                    System.out.println("Navigating to login screen");
                    app().getRouter().navigate("/login");
                    break;
                case"2":
                    System.out.println("Navigating to Register screen");
                    app().getRouter().navigate("/register");
                    break;
                case"3":
                    System.out.println("Exiting Application");
                    app().setAppRunning(false);
                    break;

                default:
                    System.out.println("Invalid selection");
            }


        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Shutting down application");
            app().setAppRunning(false);

        }
    }
}
