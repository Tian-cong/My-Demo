package com.example.mydemo.designmode.enjoy.create.fatory.abstractFactory;


import com.example.mydemo.designmode.enjoy.entity.Bag;
import com.example.mydemo.designmode.enjoy.entity.Fruit;

/**
 * 抽象水果工厂
 */
public abstract class AbstractFactory {

    public abstract Fruit getFruit();

    public abstract Bag getBag();

}
