package com.example.javatest.handler;

public class Looper {

    static final ThreadLocal<Looper> mThreadLocal = new ThreadLocal<>();

    final MessageQueue messageQueue;
    final Thread mThread;


    public static void prepare() {
        if (mThreadLocal.get() != null) {
            throw new RuntimeException("you are a dog");
        }
        mThreadLocal.set(new Looper());
    }

    private Looper() {
        messageQueue = new MessageQueue();
        mThread = Thread.currentThread();
    }

    public static void loop() {
        final Looper me = MyLoop();
        if (me == null) {
            throw new RuntimeException("looper is null");
        }
        final MessageQueue queue = me.messageQueue;

        for (;;) {
            Message msg = queue.next();
            if (msg == null) {return;}
            msg.target.dispatchMessage(msg);
        }

    }

    public static Looper MyLoop() {
        return mThreadLocal.get();
    }

}
