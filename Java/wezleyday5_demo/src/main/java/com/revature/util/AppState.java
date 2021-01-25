package com.revature.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader console;
    private boolean appRunning;

    private AppState(){
        System.out.println("[LOG] - Initializing application...");

        this.appRunning = true;
        this.console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("[LOG] - Application initialized");
    }

    public BufferedReader getConsole() {
        return console;
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }
}
