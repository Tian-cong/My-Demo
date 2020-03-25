package com.example.mydemo.designmode.enjoy.create.fatory.fatoryMethod;


import com.example.mydemo.designmode.enjoy.entity.Fruit;

/**
 * 工厂方法模式测试
 * Created by Peter on 10/8 008.
 */
public class FactoryTest {

    private static FruitFactory fruitFactory;

    public static void main(String[] args) {
        //初始化苹果工厂
//        fruitFactory = new AppleFactory();//spring配置

        peterdo();
        jamesdo();
        lisondo();
    }

    //Peter自己吃水果
    public static void peterdo(){
        Fruit fruit = fruitFactory.getFruit();
        fruit.draw();
        //。。。直接啃着吃，吃掉了
        System.out.println("-----------------");
    }

    //送给james，切开吃
    public static void jamesdo(){
        Fruit fruit = fruitFactory.getFruit();
        fruit.draw();
        //。。。切开吃
        System.out.println("-----------------");
    }

    //送给lison榨汁喝
    public static void lisondo(){
        Fruit fruit = fruitFactory.getFruit();
        fruit.draw();
        //。。。榨汁动作
        System.out.println("-----------------");
    }

}
