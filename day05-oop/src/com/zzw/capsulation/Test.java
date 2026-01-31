package com.zzw.capsulation;

public class Test {
    // 认识封装性
    public static void main(String[] args) {
        // 创建Person对象,
        Person p1 = new Person();
        // 使用set方法设置属性值,
        p1.setName("李四");
        p1.setAge(30);
        // 使用get方法获取属性值,

        System.out.println("姓名：" + p1.getName());
        System.out.println("年龄：" + p1.getAge());
    }
}
