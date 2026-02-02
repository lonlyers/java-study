package com.zzw.innerclass2;

public class Test {
    // 认识匿名内部，了解其使用场景
    // 匿名内部类是没有名字的类，通常用来简化代码
    // 使用场景：当父类或者接口的子类对象只需要使用一次时，可以使用匿名内部类来简化代码
    public static void main(String[] args) {

        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println("小狗吃骨头");
            }
        };
        animal.eat();
    }
}
