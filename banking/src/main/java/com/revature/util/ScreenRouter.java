package com.revature.util;

import com.revature.screens.Screen;

import java.util.LinkedList;

//facilitates the routing from one screen to another instead of instanciating a new class every time
//complications with creating new objects for each screen; we only need one instance of each screen
public class ScreenRouter {
    private Set<Screen> screens=new Set<>();

    // getter method for linked list
    public Set<Screen> getScreen(){
        return screens;
    }


    //adding a type of screen for the user
    public ScreenRouter addScreen(Screen screen){
        System.out.println("[LOG] - Loading "+screen.getName()+" into router");
        screens.add(screen);
        return this;
    }

    //searching through an array of screens to navigate to the correct one once called
    public void navigate(String route){

       for(Screen screen : screens.toArray(Screen.class)){
           if(screen.getRoute().equals(route)){
               screen.render();
           }
       }

    }

}
