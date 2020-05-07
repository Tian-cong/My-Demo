package com.example.javatest.handler;

public class Message {

    Object object;
    Handler target;


    public Message(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return object.toString();
    }
}
