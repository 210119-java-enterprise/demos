package com.revature;

import com.revature.screens.HomeScreen;
import com.revature.util.AppState;
import com.revature.util.Map;

public class Decrypter {

    // Making sure AppState is loaded before app starts
    private static AppState app = new AppState();
    public static final boolean testing = false;

    public static void main(String[] args) {
        if (!testing) {
            while (app.isAppRunning()) {
                app.getRouter().navigate("/home");
            }
        } else {
            Map<String, Integer> m0 = new Map<String, Integer>();
            m0.put("One", 1);
            m0.put("Two", 2);
            System.out.println("Testing put()... ");
            System.out.println((m0.getSize() == 2)? "\t1" : "\t1 failed");
            System.out.println((m0.getCapacity() == 16)? "\t2" : "\t2 failed");
            m0.put("Three", 3);
            m0.put("Four", 3);
            m0.put("Five", 3);
            m0.put("Six", 3);
            m0.put("Seven", 3);
            m0.put("Eight", 3);
            m0.put("Nine", 3);
            m0.put("Ten", 3);
            m0.put("Eleven", 3);
            m0.put("Twelve", 3);
            m0.put("Thirteen", 3);
            m0.put("Fourteen", 3);
            m0.put("Fifteen", 3);
            m0.put("Sixteen", 3);
            m0.put("Seventeen", 3);
            System.out.println((m0.getSize() == 17)? "\t3" : "\t3 failed");
            System.out.println((m0.getCapacity() == 32)? "\t4" : "\t4 failed");
            System.out.println((m0.put("Eighteen", 18) == null)? "\t5" : "\t5 failed");
            System.out.println((m0.put("Sixteen", 16) == 3)? "\t6" : "\t6 failed");
            System.out.println((m0.put(null, 4) == null)? "\t7" : "\t7 failed");

            System.out.println("Testing isEmpty()...");
            Map<String, Integer> m1 = new Map<String, Integer>();
            System.out.println(m1.isEmpty()? "\t1" : "\t1 failed");
            m1.put("One", 1);
            System.out.println(m1.isEmpty()? "\t2 failed" : "\t2");

            System.out.println("Testing get()...");
            System.out.println((m0.get("One") == 1)? "\t1" : "\t1 failed");
            System.out.println((m0.get("hi") == null)? "\t2" : "\t2 failed");
            System.out.println((m0.getOrDefault("Two", 4) == 2)? "\t3" : "\t3 failed");
            System.out.println((m0.getOrDefault("hi", 4) == 4)? "\t4" : "\t4 failed");
            System.out.println((m0.getOrDefault(null, 2) == 2)? "\t5" : "\t5 failed");

            System.out.println("Testing containsKey()...");
            System.out.println(m0.containsKey("One")? "\t1" : "\t1 failed");
            System.out.println(m0.containsKey("Nope")? "\t2 failed" : "\t2");
            System.out.println(m0.containsKey(null)? "\t3 failed" : "\t3");
        }
    }
    
    public static AppState app() {
        return app;
    }
}