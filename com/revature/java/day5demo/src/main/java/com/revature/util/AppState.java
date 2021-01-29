package com.revature.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.repos.UserRepository;
import com.revature.screens.HomeScreen;
import com.revature.screens.LoginScreen;
import com.revature.screens.RegisterScreen;
import com.revature.services.UserService;

public class AppState {

    private BufferedReader console;
    private Boolean appRunning;
    private ScreenRouter router;

    final UserRepository userRepo = new UserRepository();
    final UserService userService = new UserService(userRepo);

    public AppState() {
        System.out.println("[LOG] - initializing application...");

        this.appRunning = true;
        this.console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("[LOG] - Application initialized");
        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen(userService))
                .addScreen(new LoginScreen());
    }

    public BufferedReader getConsole() {
        return console;
    }

    public Boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(Boolean run) {
        appRunning = run;
    }

    public ScreenRouter getRouter() {
        return router;
    }
    
}
