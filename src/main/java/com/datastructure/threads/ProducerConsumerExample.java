package com.datastructure.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerBlockingQueue implements Runnable {

    private BlockingQueue<Integer> queue;

    public ProducerBlockingQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++){
            try {
                Thread.sleep(1000); //simulating some work
                queue.put(i);
                System.out.println("Produced: " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ConsumerBlockingQueue implements Runnable {

    private BlockingQueue<Integer> queue;

    public ConsumerBlockingQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Integer item = queue.take();
                System.out.println("Consumed: " + item);
                Thread.sleep(2000); // simulating some work
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}


public class ProducerConsumerExample {
    public static void main(String[] args) {

        // creating a blocking queue with a capacity of 5
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // creating producer and consumer threads
        ProducerBlockingQueue producer = new ProducerBlockingQueue(queue);
        ConsumerBlockingQueue consumer = new ConsumerBlockingQueue(queue);

        // starting producer & consumer threads
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

    }
}
