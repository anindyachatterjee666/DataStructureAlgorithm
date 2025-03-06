package com.datastructure.threads;

import java.util.concurrent.atomic.AtomicInteger;

    // Issue -> Race Condition
//class SharedCounter {
//    private int count;
//
//    public void increment(){
//        count++;
//    }
//
//    public int getCount(){
//        return count;
//    }
//}


    // Solution-1 -> use AtomicInteger
//class SharedCounter {
//
//    // handling Race-Condition
//    private AtomicInteger count = new AtomicInteger(0);
//
//    public void increment(){
//        count.incrementAndGet();
//    }
//
//    public int getCount(){
//        return count.get();
//    }
//}


    // Solution-2 -> use "synchronised" at method level
//class SharedCounter {
//    private int count;
//
//    public synchronized void increment(){
//        count++;
//    }
//
//    public int getCount(){
//        return count;
//    }
//}


    // Solution-3 -> use "synchronised" at the particular place.
//class SharedCounter {
//    private int count;
//
//    public void increment(){
//        // other logic
//        synchronized (this){
//            count++;
//        }
//    }
//
//    public int getCount(){
//        return count;
//    }
//}


// Solution-4 -> use "synchronised" with "static" at the particular place.
class SharedCounter {
    private static int count;

    public static void increment(){
        // other logic
        synchronized (SharedCounter.class){
            count++;
        }
    }

    public int getCount(){
        return count;
    }
}

public class Atomic {
    public static void main(String[] args) throws InterruptedException {

        SharedCounter sharedCounter = new SharedCounter();

        // Thread-1
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread-1 started");
            for(int i=0; i<50000; i++){
                sharedCounter.increment();
            }
            System.out.println("Thread-1 completed");
        });

        // Thread-2
        Thread thread2= new Thread(() -> {
            System.out.println("Thread-2 started");
            for(int i=0; i<50000; i++){
                sharedCounter.increment();
            }
            System.out.println("Thread-2 completed");
        });

        thread1.start();
        thread2.start();

        // Thread.join(): Ensures the main thread waits until both thread1 and thread2 finish execution.
        thread1.join();
        thread2.join();

        System.out.println("Total Count: " + sharedCounter.getCount());

    } // end main
}
