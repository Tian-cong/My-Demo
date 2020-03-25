package com.example.mydemo.designmode.enjoy.entity;


import com.example.mydemo.designmode.enjoy.action.visit.Visit;

/**
 * 水果接口
 */
public interface Fruit {

    int price();

    void draw();

    int accept(Visit visit);

}
