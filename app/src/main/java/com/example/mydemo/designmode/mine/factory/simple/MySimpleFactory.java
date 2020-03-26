package com.example.mydemo.designmode.mine.factory.simple;

public class MySimpleFactory {

    public static final int DOG = 1;
    public static final int PIG = 2;

    public Animal getDog() {
        return new Dog();
    }

    public Animal getPig() {
        return new Pig();
    }

    public Animal getAnimal(int type) {
        switch (type) {
            case DOG:
                return new Dog();
            case PIG:
                return new Pig();
        }
        return new Animal() {
            @Override
            protected void eat() {
                System.out.println("未知动物");
            }
        };
    }
}
