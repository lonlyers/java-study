package com.zzw.constructor;

public class Person {
    // 成员变量
    String name;
    int age;
    String gender;
    public  Person() {
        // 无参构造器
        this.name = "默认姓名";
        this.age = 0;
        this.gender = "默认性别";

    }
    public Person(String name, int age, String gender) {
        // 有参构造器
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
