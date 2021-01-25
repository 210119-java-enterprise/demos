package com.revature.util;

import com.revature.screens.Screen;
import sun.awt.image.ImageWatched;

public class ScreenRouter {

    private LinkedList<Screen> screens = new LinkedList<>();

    public LinkedList<Screen> getScreens() {
        return screens;
    }

    public ScreenRouter addScreen(Screen screen) {
        System.out.println("[Log] - Loading "+ screen.getName()+" into router");
        screens.insert(screen);
        return this;
    }

    // TODO clean this up with a new data structire
    public void navigate(String route) {
        LinkedList<Screen> tempScreens = new LinkedList<>();
        Screen currentScreen = screens.pop();
        while (currentScreen != null) {
            tempScreens.insert(currentScreen);
            if (currentScreen.getRoute().equals(route)) {
                currentScreen.render();
            }
            currentScreen = screens.pop();
        }
        screens = tempScreens;
    }
}
