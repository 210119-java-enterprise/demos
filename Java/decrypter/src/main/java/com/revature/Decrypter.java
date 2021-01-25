package com.revature;

import com.revature.screens.HomeScreen;
import com.revature.util.AppState;

public class Decrypter {

    private static AppState app = new AppState();

    public static void main(String[] args) {
        System.out.println(app.isAppRunning());
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.render();
        System.out.println(app.isAppRunning());
    }

    public static AppState app() {
        return app;
    }
}
