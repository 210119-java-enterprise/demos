package com.revature.screens;

public abstract class Screen {

    protected String name;
    protected String route;

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

    //where logic will exist for what the screen will look like
    // each screen that we create will extend the screen class and implement the render method in their own way
    public abstract void render();
}
