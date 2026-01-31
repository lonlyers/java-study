package com.zzw.polymorephsm1;

public class Cat extends Animal {
    String name = "猫";
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
