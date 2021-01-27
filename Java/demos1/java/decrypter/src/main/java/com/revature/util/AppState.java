package com.revature.util;

import com.revature.screens.HomeScreen;
import com.revature.screens.LoginScreen;
import com.revature.screens.RegisterScreen;
import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

//used to hold application state information and shared resources (buffered reader in)
public class AppState {

    private BufferedReader console;
    private ScreenRouter router;
    private boolean appRunning;

    public AppState() {

        System.out.println("[LOG] - Initializing application...");

        this.appRunning = true;
        this.console = new BufferedReader(new InputStreamReader(System.in));

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
                .addScreen(new RegisterScreen())
                .addScreen(new LoginScreen());

        System.out.println("[LOG] - Application initialized");

    }

    public BufferedReader getConsole() {
        return console;
    }

    public ScreenRouter getRouter() {
        return router;
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }

}
