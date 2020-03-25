package com.example.mydemo.designmode.enjoy.create.fatory.fatoryMethod;


import com.example.mydemo.designmode.enjoy.entity.Bag;
import com.example.mydemo.designmode.enjoy.entity.bag.AppleBag;

/**
 * 工厂方法模式
 */
public class AppleBagFactory implements BagFactory{
    public Bag getBag(){
        return new AppleBag();
    }
}
