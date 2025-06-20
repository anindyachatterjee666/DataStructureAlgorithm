package com.datastructure.threads;

// Legacy way to run Thread by extending Thread class
//class MyThread extends Thread {
//    public void run(){
//        System.out.println("Thread-1 is running");
//    }
//}

// main
public class CreateThreadExampleOne {
    public static Object shareObject = new Object();
    public static void main(String[] args) {

        System.out.println("Main Thread Started");

        //  Legacy way to run Thread
//        MyThread objThread1 = new MyThread();
//        objThread1.start();


        // Inside Lambda Expression we need to provide the implementation for run(). Functional Programming
//        Thread objThread2 = new Thread(() -> {
//            System.out.println("Thread-2 is running");
//        });
//        objThread2.start();


        // Use Runnable to run Threads.
//        Runnable objRunnable1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread-3 is running");
//            }
//        };
////         pass runnable object & Thread name as an argument
//        Thread objThread3 = new Thread(objRunnable1, "Runnable Thread");
//        objThread3.start();


        // Daemon Threads (Use Runnable with Lambda Expression for better code readability )
//        Runnable objRunnable2 = () -> {
//            System.out.println("Thread-4 started");
//            System.out.println("Thread State -> " + Thread.currentThread().getState());
//            System.out.println("Thread Name -> "+Thread.currentThread().getName());
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Thread-4 completed");
//        };
//        Thread objThread4 = new Thread(objRunnable2, "Runnable Thread");
//        /* Main Thread is not getting exit until the all the threads are completed. Sometimes we need to run      threads in background without impacting the Main Thread(use case-> garbage collection, resources,      logging purpose etc.). For that background tasks we don't want our main thread to wait for the other   Threads therefore we use Daemon Threads. By Default these are not Daemon Threads(objThread3,           objThread4) */
////        objThread4.setDaemon(true);
//        objThread4.start();
//        System.out.println("Main Thread Ended");



        //Shared Memory Model
//        Runnable objRunnable1 = () -> {
//            System.out.println("Thread-1 started");
//            System.out.println("Thread-1 State -> " + Thread.currentThread().getState());
//            System.out.println("Thread-1 Name -> "+Thread.currentThread().getName());
//            System.out.println(shareObject.hashCode());
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Thread-1 completed");
//        };
//
//        Runnable objRunnable2 = () -> {
//            System.out.println("Thread-2 started");
//            System.out.println("Thread-2 State -> " + Thread.currentThread().getState());
//            System.out.println("Thread-2 Name -> "+Thread.currentThread().getName());
//            System.out.println(shareObject.hashCode());
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Thread-2 completed");
//        };
//
//        Thread objThread1 = new Thread(objRunnable1, "Runnable Thread-1");
//        objThread1.start();
//
//        Thread objThread2 = new Thread(objRunnable2, "Runnable Thread-2");
//        objThread2.start();

//        System.out.println("Main Thread Ended");

    }
}
