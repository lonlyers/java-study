package com.zzw.stctic;

public class Student {
    // 成员变量
    private final String name;
    private final int age;
    // 静态变量
    static String schoolName = "默认学校名称";

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showInfo() {
        System.out.println("姓名：" + this.name);
        System.out.println("年龄：" + this.age);
        System.out.println("学校名称：" + Student.schoolName);
    }
}
