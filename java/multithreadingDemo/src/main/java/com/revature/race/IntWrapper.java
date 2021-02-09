package com.revature.race;

public class IntWrapper {

    private int val = 0;

    public int getValue() {
        return val;
    }

    // Synchronizing this method will prevent race conditions
    public void incrementValue() {
        val++;
    }
    
}
