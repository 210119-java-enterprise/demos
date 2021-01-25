package com.revature.util;

import com.revature.screens.HomeScreen;
import com.revature.screens.LoginScreen;
import com.revature.screens.RegisterScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader consoleReader;
    private boolean appRunning;
    private ScreenRouter router;

    public AppState(){
        System.out.println("[LOG] - Initializing application...");

        this.appRunning = true;
        this.consoleReader = new BufferedReader(new InputStreamReader(System.in));

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen())
                .addScreen(new LoginScreen());

        System.out.println("[LOG] - Application initialized");
    }

    public BufferedReader getConsoleReader() {
        return consoleReader;
    }

    public void setAppRunning(boolean appRunning){
        this.appRunning = appRunning;
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public ScreenRouter getRouter() {
        return router;
    }
}
