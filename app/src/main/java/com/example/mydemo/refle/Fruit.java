package com.example.mydemo.refle;

public class Fruit {

    private String apple;
    private String Banana;

    public Fruit() {
    }

    public Fruit(String apple, String banana) {
        this.apple = apple;
        Banana = banana;
    }

    public String getApple() {
        return apple;
    }

    public void setApple(String apple) {
        this.apple = apple;
    }

    public String getBanana() {
        return Banana;
    }

    public void setBanana(String banana) {
        Banana = banana;
    }

    private void haha() {
        System.out.println("private 666666666666666666666");
    }
}
