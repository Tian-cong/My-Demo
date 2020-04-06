package com.example.mydemo.thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {

    //默认线程个数
    private static int WORK_NUM = 5;

    //默认任务个数
    private static int TASK_COUNT = 100;

    //工作线程组
    private WorkThread[] workThreads;

    //任务队列
    private final BlockingQueue<Runnable> taskQueue;

    //希望启动的线程数
    private final int work_num;

    public MyThreadPool() {
        this(WORK_NUM, TASK_COUNT);
    }

    public MyThreadPool(int work_num, int taskCount) {

        if (work_num <= 0) work_num = WORK_NUM;
        if (taskCount <= 0) taskCount = TASK_COUNT;

        this.work_num = work_num;

        taskQueue = new ArrayBlockingQueue<>(taskCount);
        workThreads = new WorkThread[work_num];
        for (int i = 0; i < work_num; i++) {
            workThreads[i] = new WorkThread();
            workThreads[i].start();
        }
        Runtime.getRuntime().availableProcessors();
    }

    private class WorkThread extends Thread {
        @Override
        public void run() {
            Runnable runnable = null;
            try {
                while (!isInterrupted()) {
                    runnable = taskQueue.take();
                    if (runnable != null) {
                        runnable.run();
                    }
                    runnable = null;
                }
            } catch (Exception e) {

            }
        }

        public void stopWorker() {
            interrupt();
        }
    }

    public void execute(Runnable task) {
        taskQueue.add(task);
    }

    public void destroy() {
        for (int i = 0; i < work_num; i++) {
            workThreads[i].stopWorker();
            workThreads[i] = null;
        }
        taskQueue.clear();
    }

    @Override
    public String toString() {
        return "MyThreadPool{" +
                "workThreads=" + Arrays.toString(workThreads) +
                ", taskQueue=" + taskQueue +
                ", work_num=" + work_num +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool t = new MyThreadPool(3,0);
        t.execute(new MyTask("testA"));
        t.execute(new MyTask("testB"));
        t.execute(new MyTask("testC"));
        t.execute(new MyTask("testD"));
        t.execute(new MyTask("testE"));
        System.out.println(t);
        Thread.sleep(10000);
        t.destroy();// 所有线程都执行完成才destory
        System.out.println(t);

    }


    static class MyTask implements Runnable {

        private String name;
        private Random r = new Random();

        public MyTask(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {// 执行任务
            try {
                Thread.sleep(r.nextInt(1000)+2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getId()+" sleep InterruptedException:"
                        +Thread.currentThread().isInterrupted());
            }
            System.out.println("任务 " + name + " 完成");
        }
    }

}
