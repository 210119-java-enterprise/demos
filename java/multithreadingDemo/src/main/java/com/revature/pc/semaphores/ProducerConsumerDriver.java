package com.revature.pc.semaphores;

import java.util.concurrent.Semaphore;

public class ProducerConsumerDriver {
    
    public static void main(String[] args) throws InterruptedException {
        CustomBuffer buf = new CustomBuffer();

        final Semaphore semaphore = new Semaphore(1, true);
        Producer producer = new Producer(buf, semaphore);
        Consumer consumer = new Consumer(buf, semaphore);

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

        producerThread.join();
        consumerThread.join();

        System.out.println("Final buffer count: " + buf.getCount());
    }
}
