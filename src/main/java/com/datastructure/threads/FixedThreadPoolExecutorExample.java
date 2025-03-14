package com.datastructure.threads;

import java.util.concurrent.*;

public class FixedThreadPoolExecutorExample {
    public static void main(String[] args) {

        // Fixed Thread Pool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        // Thread Pool Executor
        ExecutorService threadPoolExecutorObject = new ThreadPoolExecutor(1,
                                            5,
                                            0L,
                                            TimeUnit.MILLISECONDS,
                                            new LinkedBlockingQueue<Runnable>(2));

        for(int i=1; i<=5; i++){
            final int taskId = i;
            threadPoolExecutorObject.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread Pool Executor "
                            + "Thread Task "
                            + taskId
                            + " executed by Thread "
                            + Thread.currentThread().getName());
            });
        }
        threadPoolExecutorObject.shutdown();
    }
}
