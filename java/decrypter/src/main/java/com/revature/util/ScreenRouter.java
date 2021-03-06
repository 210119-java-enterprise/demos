package com.revature.util;

import com.revature.screens.Screen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ScreenRouter {

    private static final Logger logger = LogManager.getLogger(ScreenRouter.class);

    private Set<Screen> screens = new Set<>();

    public Set<Screen> getScreens() {
        return screens;
    }

    public ScreenRouter addScreen(Screen screen) {
        logger.trace("Loading " + screen.getName() + " into router");
        screens.add(screen);
        return this;
    }

    // TODO clean this nastiness...implement a Set data structure
    public void navigate(String route) {

        for (Screen screen : screens.toArray(Screen.class)) {
            if (screen.getRoute().equals(route)) {
                screen.render();
            }
        }

        // leaving this for posterity
//        LinkedList<Screen> tempScreens = new LinkedList<>();
//        Screen currentScreen = screens.pop();
//
//        while (currentScreen != null) {
//            tempScreens.insert(currentScreen);
//            if (currentScreen.getRoute().equals(route)) {
//                currentScreen.render();
//            }
//            currentScreen = screens.pop();
//        }
//        screens = tempScreens;

    }

}
