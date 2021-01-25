package com.revature;

import com.revature.util.AppState;
import com.revature.views.HomeScreen;

public class Decrypter {

    private static AppState app = new AppState();
    public static void main(String[] args) {

        HomeScreen homeScreen = new HomeScreen();
        homeScreen.render();

    }

    public static AppState getApp() {
        return app;
    }
}
