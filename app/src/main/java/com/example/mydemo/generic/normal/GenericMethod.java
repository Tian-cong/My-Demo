package com.example.mydemo.generic.normal;

public class GenericMethod {

    public <T> void genericMethod0(T t) {


    }
    public <T> String genericMethod1(T t) {
        return t.toString();
    }

    public <T> T genericMethod(T t) {
        return t;
    }

}
