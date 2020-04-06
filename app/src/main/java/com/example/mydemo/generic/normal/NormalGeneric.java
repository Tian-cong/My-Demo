package com.example.mydemo.generic.normal;

public class NormalGeneric<T> {
    private T data;

    public NormalGeneric(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        NormalGeneric<String> normalGeneric = new NormalGeneric<>("haha");
        normalGeneric.getData();
    }
}
