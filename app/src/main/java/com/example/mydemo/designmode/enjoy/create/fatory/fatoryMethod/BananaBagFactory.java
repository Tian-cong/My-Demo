package com.example.mydemo.designmode.enjoy.create.fatory.fatoryMethod;


import com.example.mydemo.designmode.enjoy.entity.Bag;
import com.example.mydemo.designmode.enjoy.entity.bag.BananaBag;

/**
 * 工厂方法模式
 */
public class BananaBagFactory implements BagFactory{
    public Bag getBag(){
        return new BananaBag();
    }
}
