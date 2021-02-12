package com.revature.pc.blocking_queue;

public class Consumer {

    private CustomBuffer buffer;

    public Consumer(CustomBuffer buffer) {
        this.buffer = buffer;
    }

    public void consume() {

        if (!buffer.isEmpty()) {
            try {
                int consumedValue = buffer.getBufferQueue().take();
                System.out.println("\tConsumed new value: " + consumedValue);
                System.out.println("\tArray contents: " + buffer.printBufferContents());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
