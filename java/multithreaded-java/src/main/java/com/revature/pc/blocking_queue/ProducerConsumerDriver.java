package com.revature.pc.blocking_queue;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class ProducerConsumerDriver {

    public static void main(String[] args) throws InterruptedException {

        SynchronousQueue myQueue = new SynchronousQueue();

        Producer producer = new Producer(myQueue);
        Consumer consumer = new Consumer(myQueue);

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

    }
}
