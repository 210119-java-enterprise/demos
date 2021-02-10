package com.revature.screens;

public abstract class Screen {

    protected String Name;
    protected String Route;

    public Screen(String name, String route) {
        Name = name;
        Route = route;
    }

    public String getName() {
        return Name;
    }

    public String getRoute() {
        return Route;
    }

    public abstract void render();
}
