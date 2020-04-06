package com.example.mydemo.thread;

import androidx.annotation.Nullable;

public class UseThreadLocal {


    static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
        @Nullable
        @Override
        protected String initialValue() {
            return "sb";
        }
    };


    public static void main(String[] args) {

    }

    private static class TestThread implements Runnable {

        @Override
        public void run() {
            String s = threadLocal.get();
            s = "ha  " + s;
            threadLocal.set(s);
        }
    }


}
