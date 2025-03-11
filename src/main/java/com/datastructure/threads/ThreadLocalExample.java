package com.datastructure.threads;

public class ThreadLocalExample {
    public static void main(String[] args) {

        ThreadLocal<Long> userIdThreadLocal = new ThreadLocal<>();

        // simulate a user landing on the webpage
        Long userId1 = 1L;
        Long userId2 = 2L;

        // Handle the request in Thread-1
        Thread requestThread1 = new Thread(() -> {
            System.out.println("Started Thread for user" + userId1);
            userIdThreadLocal.set(userId1);
            // process my logic
            // database call
            System.out.println("Completed logic for user" + userIdThreadLocal.get());
            // good practice to remove ThreadLocal object
            userIdThreadLocal.remove();
            System.out.println("Removed user " + userIdThreadLocal.get()); // we will get null as we removed previously
        });

        // Handle the request in Thread-2
        Thread requestThread2 = new Thread(() -> {
            System.out.println("Started Thread for user" + userId2);
            userIdThreadLocal.set(userId2);
            // process my logic
            // database call
            System.out.println("Completed logic for user" + userIdThreadLocal.get());
            // good practice to remove ThreadLocal object
            userIdThreadLocal.remove();
            System.out.println("Removed user " + userIdThreadLocal.get()); // we will get null as we removed previously
        });

//        requestThread1.start();
//        requestThread2.start();


        // Use-case -> you want the child threads to inherit some data or state from the parent thread
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        Thread thread3 = new Thread(() -> {
            inheritableThreadLocal.set("Instagram");
            userIdThreadLocal.set(12L); // This value can't be accessed in child Thread.
            System.out.println(userIdThreadLocal.get());
            Thread thread4 = new Thread(() -> {
                System.out.println(inheritableThreadLocal.get());
                System.out.println(userIdThreadLocal.get()); // return NULL
            });
            thread4.start();
        });
        thread3.start();

    } // main
}

