package com.revature;

import com.revature.screens.HomeScreen;
import com.revature.util.AppState;

public class Decrypter {

    private static AppState app = new AppState();

    public static void main(String[] args) {

        while (app.isAppRunning()) {
            app.get();
        }

    }

    public static AppState app() {
        return app;
    }
}
