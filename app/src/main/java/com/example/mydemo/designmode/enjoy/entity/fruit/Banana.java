package com.example.mydemo.designmode.enjoy.entity.fruit;


import com.example.mydemo.designmode.enjoy.action.visit.Visit;
import com.example.mydemo.designmode.enjoy.entity.Fruit;
import com.example.mydemo.designmode.enjoy.entity.bag.BananaBag;

/**
 * 桔子
 * Created by Peter on 10/9 009.
 */
public class Banana implements Fruit {
    private int price = 60;
    @Override
    public int price() {
        return price;
    }

    public void pack(BananaBag bag){
        bag.pack();
    }
    @Override
    public void draw() {
        System.out.print("仙人蕉");
    }

    public int accept(Visit visit){
        return visit.sell(this);
    }

    public void setPrice(int price) {
        this.price = price;
    }
}