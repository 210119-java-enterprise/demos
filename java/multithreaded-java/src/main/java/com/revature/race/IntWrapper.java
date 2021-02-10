package com.revature.race;

public class IntWrapper {

    private int value = 0;

    public int getValue() {
        return value;
    }

    // synchronizing this method will prevent race conditions
    public void incrementValue() {
        value = value + 1;
    }

}
