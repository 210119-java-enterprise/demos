package com.revature.views;

public class LoginScreen extends Screen{

    public LoginScreen()
    {
        super("LoginScreen", "/LoginScreen");
    }
    @Override
    public void render(){
        System.out.println("LoginScreen works");
    }
}
