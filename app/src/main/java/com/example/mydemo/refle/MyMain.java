package com.example.mydemo.refle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Fruit fruit = new Fruit();

        Class Fruit = Fruit.class;
        Class Fruit2 = fruit.getClass();
        Class Fruit3 = Class.forName("com.example.mydemo.refle.Fruit");

        Constructor[] constructors = Fruit2.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        Constructor constructor = Fruit2.getConstructor(String.class,String.class);
        System.out.println(constructor);

        Fruit obj = (com.example.mydemo.refle.Fruit) constructor.newInstance("ssss","yyy");

        Method[] methods = Fruit2.getMethods();
        for (Method method: methods) {
            System.out.println(method);
        }
        Method method = Fruit2.getDeclaredMethod("getBanana");
        method.invoke(obj);

        Method method_p = Fruit2.getDeclaredMethod("haha");
        method_p.setAccessible(true);

        method_p.invoke(obj);





    }

}
