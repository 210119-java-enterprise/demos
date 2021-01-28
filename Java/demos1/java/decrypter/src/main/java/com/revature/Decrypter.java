package com.revature;

import com.revature.screens.HomeScreen;
import com.revature.util.AppState;
import com.revature.util.Map;

public class Decrypter {

    private static AppState app = new AppState();

    public static void main(String[] args) {
        Map<Integer, Double> testMap = new Map<Integer, Double>();
        testMap.put(1, 20.0);
        testMap.put(2, 21.0);
        testMap.put(3, 22.0);
        testMap.put(4, 23.0);
        testMap.remove(4);
        System.out.println("map test size " + testMap.size());
        System.out.println("contains? 2 " + testMap.containsKey(2));
        System.out.println("get 2? " + testMap.get(2));


        testMap.printMap();


//        while (app.isAppRunning()) {
//            app.getRouter().navigate("/home");
//        }
    }

    //method to get the application?
    public static AppState app() {
        return app;
    }

}
