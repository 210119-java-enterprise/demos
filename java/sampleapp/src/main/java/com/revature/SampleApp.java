package com.revature;

import com.revature.screens.HomeScreen;
import com.revature.util.AppState;

public class SampleApp {

    private static AppState app = new AppState();

    public static void main(String[] args){

        while(app.isAppRunning()){
            app.getRouter().navigate("/home");
        }
    }

    public static AppState app(){
        return app;
    }
}
