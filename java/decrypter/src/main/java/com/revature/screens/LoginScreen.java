package com.revature.screens;

import com.revature.models.AppUser;
import com.revature.services.UserService;

import static com.revature.Decrypter.app;

public class LoginScreen extends Screen {

    private UserService userService;

    public LoginScreen(UserService userService) {
        super("LoginScreen", "/login");
        this.userService = userService;
    }

    @Override
    public void render() {
        String username;
        String password;

        try {

            System.out.println("+---------------------+");
            System.out.println("Login to your account!");
            System.out.print("Username: ");
            username = app().getConsole().readLine();
            System.out.print("Password: ");
            password = app().getConsole().readLine();

            AppUser returningUser = userService.login(username, password);

            while (returningUser == null){
                System.out.println("Your account information was incorrect. Please try again.");
                System.out.print("Username: ");
                username = app().getConsole().readLine();
                System.out.print("Password: ");
                password = app().getConsole().readLine();

                returningUser = userService.login(username, password);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
