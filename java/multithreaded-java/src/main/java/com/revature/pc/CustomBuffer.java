package com.revature.pc;

public class CustomBuffer {

    private int[] bufferArray;
    private int count;

    public CustomBuffer() {
        bufferArray = new int[10];
        count = 0;
    }

    public int[] getBufferArray() {
        return bufferArray;
    }

    public int getCount() {
        return count;
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
        return count == bufferArray.length;
    }

}
