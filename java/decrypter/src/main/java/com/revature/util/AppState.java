package com.revature.util;

import com.revature.repos.UserRepository;
import com.revature.screens.HomeScreen;
import com.revature.screens.LoginScreen;
import com.revature.screens.RegisterScreen;
import com.revature.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private static final Logger logger = LogManager.getLogger(AppState.class);

    private BufferedReader console;
    private ScreenRouter router;
    private Session currentSession;
    private boolean appRunning;

    public AppState() {

        logger.info("Initializing application");

        this.appRunning = true;
        this.console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();

        final UserService userService = new UserService(userRepo);

        router = new ScreenRouter();
        router.addScreen(new HomeScreen())
              .addScreen(new RegisterScreen(userService))
              .addScreen(new LoginScreen(userService));

        logger.info("Application initialized");

    }

    public BufferedReader getConsole() {
        return console;
    }

    public ScreenRouter getRouter() {
        return router;
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public void invalidateCurrentSession() {
        this.currentSession = null;
    }

    public boolean isSessionValid() {
        return (this.currentSession != null);
    }

}
