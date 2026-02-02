package com.zzw.code;

public class CodeDemo2 {
    // 构造代码块,每次创建对象时执行
    // 一般用于初始化对象的成员变量
    String name;
    int age;
    public CodeDemo2() {
        System.out.println("无参构造器被执行");
    }
    public CodeDemo2(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("有参构造器被执行");
    }
    {
        System.out.println("构造代码块被执行");
        name = "默认姓名";
        age = 0;
    }
}
