package com.revature.exceptions;

import com.sun.javaws.JAuthenticator;

public class LoginScreen {

    public static void main(String[] args) {
        throw new AuthenticationException("No particular reason", new NullPointerException());
    }
}
