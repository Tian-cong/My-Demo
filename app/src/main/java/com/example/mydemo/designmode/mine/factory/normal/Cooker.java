package com.example.mydemo.designmode.mine.factory.normal;

public class Cooker {

    public static void main(String[] args) {
//        DogFactory dogFactory = new DogFactory();
//        Dog dog = (Dog) dogFactory.getAnimal();
//        dog.eat();

        CookFactory cookFactory = new DogFactory();
        Animal animal = cookFactory.getAnimal();
        animal.eat();
    }
}
