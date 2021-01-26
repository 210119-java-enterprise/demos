package com.revature;

import com.revature.screens.HomeScreen;
import com.revature.util.AppState;

public class Decrypter {

    private static AppState app = new AppState();

    public static void main(String[] args) {
//        HomeScreen homeScreen = new HomeScreen();
//        homeScreen.render();
        while(app.isAppRunning()){

        }
    }

    public static AppState app(){
        return app;
    }
}
