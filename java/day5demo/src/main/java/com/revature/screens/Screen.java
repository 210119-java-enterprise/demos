package com.revature.screens;

public abstract class Screen {

    protected String name, route;

    public Screen(String name, String route) {
        this.name = name;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    // Logic for displaying screen
    public abstract void render();
}
