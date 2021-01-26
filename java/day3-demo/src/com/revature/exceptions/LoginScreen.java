package com.revature.exceptions;

public class LoginScreen {

    public static void main(String[] args) {
        throw new AuthenticationException("No particular reason", new NullPointerException());
    }
}
