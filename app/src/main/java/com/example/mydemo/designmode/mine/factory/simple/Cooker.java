package com.example.mydemo.designmode.mine.factory.simple;

public class Cooker {


    public static void main(String[] args) {
        MySimpleFactory mySimpleFactory = new MySimpleFactory();
        Dog dog = (Dog) mySimpleFactory.getDog();
        dog.eat();
    }


}
