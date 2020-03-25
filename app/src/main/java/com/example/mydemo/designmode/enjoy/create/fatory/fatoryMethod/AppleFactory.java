package com.example.mydemo.designmode.enjoy.create.fatory.fatoryMethod;


import com.example.mydemo.designmode.enjoy.entity.Fruit;
import com.example.mydemo.designmode.enjoy.entity.fruit.Apple;

/**
 * 工厂方法模式
 */
public class AppleFactory implements FruitFactory{
    public Fruit getFruit(){
        return new Apple();
    }
}
