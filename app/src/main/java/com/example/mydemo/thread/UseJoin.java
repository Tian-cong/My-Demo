package com.example.mydemo.thread;

public class UseJoin {


    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        C c = new C();
        b.start();



    }

    private static class joinThread implements Runnable {

        private Thread thread;

        public joinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static class A extends Thread {
        @Override
        public void run() {
            B b = new B();
            try {
                b.join();
                b.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A");
        }
    }

    private static class B extends Thread {
        @Override
        public void run() {
            C c = new C();
            try {
                c.join();
                c.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    private static class C extends Thread {
        @Override
        public void run() {
            System.out.println("C");
        }
    }

}
