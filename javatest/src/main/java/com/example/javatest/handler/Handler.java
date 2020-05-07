package com.example.javatest.handler;

public class Handler {

    final Looper mLooper;
    final MessageQueue mQueue;


    public Handler() {
        this.mLooper = Looper.MyLoop();
        this.mQueue = mLooper.messageQueue;
    }

    public void sendMessage(Message msg) {
         enqueueMessage(msg);
    }

    private void enqueueMessage(Message msg) {
        msg.target = this;
        mQueue.enqueueMessage(msg);
    }

    public void dispatchMessage(Message msg) {
        handlerMessage(msg);
    }

    public void handlerMessage(Message msg) {
        //TODO
    }

}
