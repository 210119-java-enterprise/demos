package com.revature.screens;

import com.revature.models.AppUser;
import com.revature.services.UserService;

import static com.revature.Decrypter.app;

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

            System.out.println("+---------------------+");
            System.out.println("Log into your account");

            System.out.print("Username: ");
            username = app().getConsole().readLine();
            System.out.print("Password: ");
            password = app().getConsole().readLine();

            AppUser user = userService.login( username,  password);
            System.out.println("Logged in");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
