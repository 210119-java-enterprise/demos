package com.revature.pc;

public class CustomBuffer {

    private int[] buffer;
    private int count;

    public CustomBuffer() {
        buffer = new int[10];
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public int[] getBuffer() {
        return buffer;
    }

    public void incrementCount() {
        ++count;
    }

    public void decrementCount() {
        --count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == buffer.length;
    }
}
