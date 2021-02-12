package com.revature.pc.semaphore;

public class Consumer {

    private CustomBuffer buffer;

    public Consumer(CustomBuffer buffer) {
        this.buffer = buffer;
    }

    public void consume() {

        if (!buffer.isEmpty()) {
            int consumedValue = buffer.getBufferArray()[buffer.getCount() - 1];
            buffer.decrementCount();
            System.out.println("\tConsumed new value: " + consumedValue);
            System.out.println("\tArray contents: " + buffer.printBufferContents());
        }
    }
}
