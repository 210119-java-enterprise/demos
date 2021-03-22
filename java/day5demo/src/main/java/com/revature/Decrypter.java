package com.revature;

import com.revature.util.AppState;

// Import log4j classes.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Decrypter {

    // Making sure AppState is loaded before app starts
    private static AppState app = new AppState();

    
    private static final Logger logger = LogManager.getLogger(Decrypter.class);

    public static void main(String[] args) {
        logger.fatal("help");
        while (app.isAppRunning()) {
            app.getRouter().navigate("/home");
        }
    }
    
    public static AppState app() {
        return app;
    }
}