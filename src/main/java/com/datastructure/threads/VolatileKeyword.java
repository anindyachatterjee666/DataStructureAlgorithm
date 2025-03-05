package com.datastructure.threads;

class SharedResource {

//    make it volatile to avoid "visibility" issue.
    private boolean flag = false;

//    make the getter & setter "synchronised" to avoid "visibility" issue.
    public boolean getFlag(){
        return flag;
    }
    public void setFlag(boolean flag){
        this.flag = flag;
    }
}

public class VolatileKeyword {
    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        // thread 1
        new Thread(() -> {
            System.out.println("Thread-1 started");
            try{
                System.out.println("Thread-1 logic started");
                Thread.sleep(1000);
                System.out.println("Thread-1 logic completed");
                sharedResource.setFlag(true);
                System.out.println("Flag set by Thread-1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // thread 2
        new Thread(() -> {
            System.out.println("Thread-2 started");
            while (!sharedResource.getFlag()){
                // it will run until flag value is true
            }
            System.out.println("Thread-2 logic completed");
        }).start();

        /*
            visibility issue -> If we don't use "volatile" or "synchronised" keyword it may rise "visibility" issue. Suppose both the threads are dealing with object-1. Thread-1 updates the value of object-1 & it is taking some time to move the value to the Main Memory(RAM). At the same time Thread-2 is trying to fetch the data from the main memory at that time it won't receive the updated value.

            Internal Working -> if we use "volatile" or "synchronised" keyword, As soon as the value is updated by thread-1 it will put the value in main memory. so Thread-2 will get the updated value.

         */
    }
}