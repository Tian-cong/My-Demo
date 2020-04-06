package com.example.mydemo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread1 thread1 = new Thread1();
        thread1.start();

        Thread2 thread2 = new Thread2();
        new Thread(thread2).start();

        Thread3 thread3 = new Thread3();
        FutureTask<String> futureTask = new FutureTask<>(thread3);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            super.run();
        }
    }

    private static class Thread2 implements Runnable {

        @Override
        public void run() {

        }
    }

    private static class Thread3 implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "sb";
        }
    }


}
