package com.revature.pc.blocking_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerDriver {
    
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        Runnable produceTask = () -> {
            while (true) {
                producer.produce();
            }
            // System.out.println("Done producing");
        };
        Runnable consumeTask = () -> {
            while (true) {
                consumer.consume();
            }
            // System.out.println("Done consuming");
        };

        Thread producerThread = new Thread(produceTask);
        Thread consumerThread = new Thread(consumeTask);

        // 0-10 (10 being highest, 0 being lowest, 5 being default) Just a suggestion to JVM
        producerThread.setPriority(8);
        consumerThread.setPriority(3);

        producerThread.start();
        consumerThread.start();

        producerThread.join(5000);
        consumerThread.join(5000);

        producerThread.stop();
        consumerThread.stop();

        System.out.println("Final buffer count: " + blockingQueue.size());
    }
}
