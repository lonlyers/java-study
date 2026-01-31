package com.zzw.extends2modifie;

public class Test {
    // 认识四种权限修饰符的修饰范围
    public static void main(String[] args) {
        // 创建一个Student对象
        Student stu = new Student();
        // 访问public修饰的成员变量和方法
        stu.name = "李四";
        stu.setAge(20);
        System.out.println("姓名：" + stu.name);
        System.out.println("年龄：" + stu.getAge());

        // 访问protected修饰的成员变量和方法
        stu.score = 95;
        stu.setGrade("A");
        System.out.println("分数：" + stu.score);
        System.out.println("等级：" + stu.getGrade());

        // 访问default修饰的成员变量和方法
        stu.address = "北京市";
        stu.setPhone("12345678901");
        System.out.println("地址：" + stu.address);
        System.out.println("电话：" + stu.getPhone());

        // 不能访问private修饰的成员变量和方法
        // stu.id = "S001"; // 编译错误
        // stu.setId("S001"); // 编译错误
    }
}
