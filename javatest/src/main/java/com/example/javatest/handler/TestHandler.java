package com.example.javatest.handler;

import java.util.UUID;

public class TestHandler {

    public static void main(String[] args) {
        Looper.prepare();

        final Handler handler = new Handler() {
            @Override
            public void handlerMessage(Message msg) {
                System.out.println("Thread:  " + Thread.currentThread().getName() + "   msg  " + msg.toString());
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String s;
                        synchronized (UUID.class) {
                            s = UUID.randomUUID().toString();
                        }
                        Message message = new Message(s);
                        System.out.println(Thread.currentThread().getName() + "    " + message);
                        handler.sendMessage(message);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        Looper.loop();
    }
}
