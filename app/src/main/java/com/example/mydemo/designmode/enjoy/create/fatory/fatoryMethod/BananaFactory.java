package com.example.mydemo.designmode.enjoy.create.fatory.fatoryMethod;


import com.example.mydemo.designmode.enjoy.entity.Fruit;
import com.example.mydemo.designmode.enjoy.entity.fruit.Banana;

/**
 * 工厂方法模式
 */
public class BananaFactory implements FruitFactory{
    public Fruit getFruit(){
        return new Banana();
    }
}
