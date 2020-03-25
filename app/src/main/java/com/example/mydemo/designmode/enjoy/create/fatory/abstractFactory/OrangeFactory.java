package com.example.mydemo.designmode.enjoy.create.fatory.abstractFactory;


import com.example.mydemo.designmode.enjoy.entity.Bag;
import com.example.mydemo.designmode.enjoy.entity.Fruit;
import com.example.mydemo.designmode.enjoy.entity.bag.OrangeBag;
import com.example.mydemo.designmode.enjoy.entity.fruit.Orange;

/**
 * 水果工厂
 */
public class OrangeFactory extends AbstractFactory{

    @Override
    public Fruit getFruit() {
        return new Orange("Peter",50);
    }

    @Override
    public Bag getBag() {
        return new OrangeBag();
    }
}
