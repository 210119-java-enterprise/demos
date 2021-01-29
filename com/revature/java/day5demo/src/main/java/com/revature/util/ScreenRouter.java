package com.revature.util;

import com.revature.screens.Screen;

public class ScreenRouter {

    // private MyLinkedList<Screen> screens = new MyLinkedList<>();
    private Set<Screen> screens = new Set<>();

    public Set<Screen> getScreens() {
        return screens;
    }

    public ScreenRouter addScreen(Screen screen) {
        System.out.println("[LOG] Loading screen " + screen.getRoute() + " into router...");
        screens.add(screen);
        return this;
    }

    public void navigate(String route) {
        for (Screen screen : screens.toArray(Screen.class)) {
            if (screen != null && screen.getRoute().equals(route)) {
                screen.render();
            }
        }



        // Implementation with LinkedLists

        // MyLinkedList<Screen> tempScreens = new MyLinkedList<>();
        // Screen currentScreen = screens.pop();
        // while (currentScreen != null) {
        //     tempScreens.append(currentScreen);
        //     if (currentScreen.getRoute().equals(route)) {
        //         currentScreen.render();
        //     }
        //     currentScreen = screens.pop();
        // }
        // screens = tempScreens;
    }
    
}
