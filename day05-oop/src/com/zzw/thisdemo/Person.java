package com.zzw.thisdemo;

public class Person {
    // 成员变量
    String name;
    int age;

    public Person(String name, int age) {
        // 使用this区分成员变量和局部变量,
        this.name = name;
        this.age = age;
    }

    public void showInfo() {
        // 使用this调用当前对象的成员变量,
        System.out.println("姓名：" + this.name);
        System.out.println("年龄：" + this.age);
    }
}
