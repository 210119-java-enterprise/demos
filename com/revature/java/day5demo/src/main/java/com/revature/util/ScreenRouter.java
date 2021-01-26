package com.revature.util;

import com.revature.screens.Screen;

public class ScreenRouter {

    private MyLinkedList<Screen> screens = new MyLinkedList<>();

    public MyLinkedList<Screen> getScreens() {
        return screens;
    }

    public ScreenRouter addScreen(Screen screen) {
        System.out.println("[LOG] Loading screen " + screen.getRoute() + " into router...");
        screens.append(screen);
        return this;
    }

    // TODO: implement a Set datastructure that can be converted to an array
    public void navigate(String route) {
        MyLinkedList<Screen> tempScreens = new MyLinkedList<>();
        Screen currentScreen = screens.pop();
        while (currentScreen != null) {
            tempScreens.append(currentScreen);
            if (currentScreen.getRoute().equals(route)) {
                currentScreen.render();
            }
            currentScreen = screens.pop();
        }
        screens = tempScreens;
    }
    
}
