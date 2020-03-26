package com.example.mydemo.designmode.mine.factory.normal;

public class DogFactory implements CookFactory {
    @Override
    public Animal getAnimal() {
        return new Dog();
    }
}
