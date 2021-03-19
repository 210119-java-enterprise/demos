package com.revature.models;

public enum UserRole {
    ADMIN, BASIC_USER, PREMIUM_USER;

    // Faster than using UserRole.values()[x]
    public static UserRole fromInteger(int x) {
        switch (x) {
            case 0:
                return ADMIN;
            case 1:
                return BASIC_USER;
            case 2:
                return PREMIUM_USER;
            default:
                return null;
        }
    }
}
