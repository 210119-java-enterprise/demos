package com.revature;

import com.revature.screens.HomeScreen;
import com.revature.util.AppState;

public class BankingApp {

    private static AppState app =new AppState();

   public static void main(String[] args){
       while(app.isAppRunning()){
           app.getRouter().navigate("/home");
       }
    }


    //convenient to use, also works if we made the object public instead of private
    public static AppState app(){
        return app;
    }


}
