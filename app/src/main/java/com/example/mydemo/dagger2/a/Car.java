package com.example.mydemo.dagger2.a;


import javax.inject.Inject;

public class Car {

    @Inject
    public Enjine enjine;

    public Car() {
        DaggerCarCompoment.builder().build().in(this);
    }

    public Enjine getEnjine() {
        return enjine;
    }

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.getEnjine());
    }

}
