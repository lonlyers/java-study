package com.zzw.constructor;

public class Test {
    // 认识类的构造器

    public static void main(String[] args) {
        // 使用无参构造器创建对象
        Person p1 = new Person();
        System.out.println("p1的信息：");
        System.out.println("姓名：" + p1.name);
        System.out.println("年龄：" + p1.age);
        System.out.println("性别：" + p1.gender);
        // 使用有参构造器创建对象
        Person p2 = new Person("赵六", 28, "女");
        System.out.println("p2的信息：");
        System.out.println("姓名：" + p2.name);
        System.out.println("年龄：" + p2.age);
        System.out.println("性别：" + p2.gender);
    }

}
