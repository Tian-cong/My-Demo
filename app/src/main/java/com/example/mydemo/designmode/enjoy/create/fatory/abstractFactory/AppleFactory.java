package com.example.mydemo.designmode.enjoy.create.fatory.abstractFactory;


import com.example.mydemo.designmode.enjoy.entity.Bag;
import com.example.mydemo.designmode.enjoy.entity.Fruit;
import com.example.mydemo.designmode.enjoy.entity.bag.AppleBag;
import com.example.mydemo.designmode.enjoy.entity.fruit.Apple;

/**
 * 水果工厂
 */
public class AppleFactory extends AbstractFactory{

    @Override
    public Fruit getFruit() {
        return new Apple();
    }

    @Override
    public Bag getBag() {
        return new AppleBag();
    }
}
