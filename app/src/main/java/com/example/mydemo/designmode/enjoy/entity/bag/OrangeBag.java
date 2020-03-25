package com.example.mydemo.designmode.enjoy.entity.bag;


import com.example.mydemo.designmode.enjoy.entity.Bag;

/**
 * 桔子包装
 * Created by Peter on 10/9 009.
 */
public class OrangeBag implements Bag {
    @Override
    public void pack() {
        System.out.print("--桔子使用网兜包装");
    }
}
