package com.example.mydemo.designmode.mine.factory.normal;

public class PigFactory implements CookFactory {
    @Override
    public Animal getAnimal() {
        return new Pig();
    }
}
