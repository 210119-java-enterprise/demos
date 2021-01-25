package com.revature;

import com.revature.screens.HomeScreen;
import com.revature.util.AppState;

public class Decrypter {

    // Making sure AppState is loaded before app starts
    private static AppState app = new AppState();

    public static void main(String[] args) {
        HomeScreen myHome = new HomeScreen();
        myHome.render();
    }
    
    public static AppState app() {
        return app;
    }
}
