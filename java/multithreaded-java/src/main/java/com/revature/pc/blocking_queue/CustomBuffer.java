package com.revature.pc.blocking_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class CustomBuffer {

    private volatile BlockingQueue<Integer> bufferQueue;

    public CustomBuffer() {
        bufferQueue = new LinkedBlockingDeque<>(10);
    }

    public BlockingQueue<Integer> getBufferQueue() {
        return bufferQueue;
    }

    public boolean isEmpty() {
        return bufferQueue.isEmpty();
    }

    public String printBufferContents() {
        return bufferQueue.toString();
    }

}
