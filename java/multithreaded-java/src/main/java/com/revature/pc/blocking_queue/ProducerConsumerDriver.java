package com.revature.pc.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerDriver {

    public static void main(String[] args) throws InterruptedException {

        final Object monitor = new Object();
        CustomBuffer buffer = new CustomBuffer();

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

        Producer producer = new Producer(buffer, queue);
        Consumer consumer = new Consumer(buffer, queue);

        Runnable produceTask = () -> {
            for (int i = 0; i < 50; i++) {
                producer.produce();
            }
            System.out.println("Done producing!");
        };

        Runnable consumeTask = () -> {
            for (int i = 0; i < 50; i++) {
                consumer.consume();
            }
            System.out.println("Done consuming!");
        };

        Thread producerThread = new Thread(produceTask);
        Thread consumerThread = new Thread(consumeTask);

        // 0 - 10 (0 being the lowest, 10 being the highest, and 5 being the default)
        producerThread.setPriority(8);
        consumerThread.setPriority(2);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Data in the buffer: " + buffer.getCount());
    }
}
