package com.datastructure.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    public static void main(String[] args) {

        // Single Thread Executor
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        System.out.println("Single Thread Executor");
        for(int i=1; i<=3; i++){
            // Without the final keyword, Java would not allow taskId to be accessed inside the lambda because the lambda may execute asynchronously, and there's no guarantee that the value of taskId would remain constant during the execution.
            final int taskId = i;
//            singleThreadExecutor.execute(() ->{
//                System.out.println("Single Thread Task " + taskId + " executed by Thread: " + Thread.currentThread().getName());
//            });
        }
        singleThreadExecutor.shutdown();


        // Fixed Thread Pool
        ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(3);
        System.out.println("\nFixed Thread Executor");
        for(int i=1; i<=5; i++){
            final int taskId = i;
//            fixedThreadExecutor.execute(() -> {
//                System.out.println("Fixed Thread Task " + taskId + " executed by Thread: " + Thread.currentThread().getName());
//            });
        }
        fixedThreadExecutor.shutdown();
        
        
        // Cached Thread Pool
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        System.out.println("\nCached Thread Executor");
        for(int i=1; i<=3; i++){
            final int taskId = i;
//            cachedThreadPool.execute(() -> {
//                System.out.println("Cached Thread Task " + taskId + " executed by Thread: " + Thread.currentThread().getName());
//            });
        }
        cachedThreadPool.shutdown();

        // Scheduled Thread Pool
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        System.out.println("\nScheduled Thread Pool");
        for(int i=1; i<=3; i++){
            final int taskId = i;
            scheduledThreadPool.schedule(() -> {
                System.out.println("Scheduled Thread Task " + taskId + " executed by Thread: " + Thread.currentThread().getName());
            }, 2, TimeUnit.SECONDS); // delays each task to execute after 3 seconds
        }
        scheduledThreadPool.shutdown();
    }
}
