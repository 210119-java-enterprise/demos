package com.revature.screens;

import static com.revature.Decrypter.app;

import com.revature.models.AppUser;

public class RegisterScreen extends Screen {

	String firstName, lastName, username, password;

	public RegisterScreen() {
		super("RegisterScreen", "/register");
	}

	@Override
	public void render() {
		try {
			System.out.println("Register screen works");
			System.out.println("\n\n\n\n\n\n\n\n\n+---------------------------+");
			System.out.println("Sign up for a new account");
			System.out.println("Enter your first name:\n> ");
			firstName = app().getConsole().readLine();
			System.out.println("Enter your last name:\n> ");
			lastName = app().getConsole().readLine();
			System.out.println("Enter your username:\n> ");
			username = app().getConsole().readLine();
			System.out.println("Enter your password:\n> ");
			password = app().getConsole().readLine();

			AppUser newUser = new AppUser(firstName, lastName, username, password);

			// Pass new user to service class to validate it, then pass it on to a dao that
			//	will attempt to persist it. We'll get something back that will let us know
			//  where to navigate from here.

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}
