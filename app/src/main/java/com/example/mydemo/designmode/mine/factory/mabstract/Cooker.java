package com.example.mydemo.designmode.mine.factory.mabstract;

public class Cooker {

    public static void main(String[] args) {
        CookFactory cookFactory = new CookFactory();
        cookFactory.getAnimal().eat();
        cookFactory.getEatAnimal().eatAnimal();

        FeedFactory feedFactory = new FeedFactory();
        feedFactory.getAnimal().eat();
        feedFactory.getEatAnimal().eatAnimal();
    }
}
