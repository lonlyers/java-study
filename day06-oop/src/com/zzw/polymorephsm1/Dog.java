package com.zzw.polymorephsm1;

public class Dog extends Animal {
    String name = "狗";
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    public void eatShift() {
        System.out.println("狗吃屎");
    }
}
