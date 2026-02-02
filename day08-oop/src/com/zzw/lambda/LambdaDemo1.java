package com.zzw.lambda;

public class LambdaDemo1 {
    // 认识Lambda表达式，了解基本原理
    // Lambda表达式的语法格式：(参数列表) -> {方法体}
    // 使用Lambda表达式的前提：必须存在函数式接口
    // 函数式接口：接口中只包含一个抽象方法的接口，称为函数式接口，可以使用@FunctionalInterface注解修饰
    public static void main(String[] args) {
        // 使用匿名内部类的方式实现Runnable接口
        Student s = new Student() {
            @Override
            public void study() {
                System.out.println("学生学习Java");
            }
        };
        s.study();
        // 使用Lambda表达式实现Runnable接口
//        Student s2 = () -> {
//            System.out.println("学生学习Python");
//        };
//        s2.study();
        // 使用Lambda表达式实现Teacher接口
        Teacher t = () -> {
            System.out.println("老师教Java");
        };
        t.teach();
    }
}

abstract  class Student {
    public abstract void study();
}
//函数式接口
@FunctionalInterface
interface Teacher {
    void teach();
}