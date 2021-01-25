package com.revature.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader console;
    private Boolean appRunning;

    public AppState() {
        System.out.println("[LOG] - initializing application...");

        this.appRunning = true;
        this.console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("[LOG] - Application initialized");
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
    
}
