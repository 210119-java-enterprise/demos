package com.revature.util;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

//used to hold application state information and shared resources (buffered reader in)
public class AppState {

    private BufferedReader console;
    private boolean appRunning;

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }

    public AppState() {
        System.out.println("[LOG] - Initializing Application...");

        this.appRunning = true;
        this.console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("[LOG] - Application initialized");
    }

    public BufferedReader getConsole() {
        return console;
    }
}
