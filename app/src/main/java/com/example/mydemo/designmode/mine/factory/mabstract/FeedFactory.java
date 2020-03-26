package com.example.mydemo.designmode.mine.factory.mabstract;

public class FeedFactory implements AbstractFactory {

    @Override
    public Animal getAnimal() {
        return new Dog() ;
    }

    @Override
    public EatAnimal getEatAnimal() {
        return new EatDog();
    }
}
