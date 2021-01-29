package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.models.AppUser;
import com.revature.services.UserService;

import static com.revature.SampleApp.app;

public class LoginScreen extends Screen{

    private UserService userService;

    public LoginScreen(UserService userService){
        super("LoginScreen","/login");
        this.userService = userService;
    }

    @Override
    public void render() {

        String username;
        String password;

        try {
            System.out.println("+--------------------+");
            System.out.println("Log into your account with your username and password");
            System.out.print("Username: ");
            username = app().getConsoleReader().readLine();
            System.out.print("Password: ");
            password = app().getConsoleReader().readLine();

            userService.authenticate(username,password);

            if(app().isSessionValid()){
                System.out.println("[LOG] Login successful, navigating to dashboard...");
                //app().getRouter().navigate("/dashboard");
            }


            //userService.register(newUser);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
