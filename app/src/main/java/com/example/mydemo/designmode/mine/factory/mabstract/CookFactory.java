package com.example.mydemo.designmode.mine.factory.mabstract;

public class CookFactory implements AbstractFactory {


    @Override
    public Animal getAnimal() {
        return new Pig();
    }

    @Override
    public EatAnimal getEatAnimal() {
        return new EatPig();
    }
}
