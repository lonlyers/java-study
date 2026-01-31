package com.zzw.capsulation;

public class Person {
    // 成员变量私有化
    private String name;
    private int age;

    // 提供公共的set方法设置属性值
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("年龄输入不合法！");
        }
    }

    // 提供公共的get方法获取属性值
    public String getName() {
        return name;
    }

    public int getAge() {
        System.out.println(this);
        return age;
    }
}
