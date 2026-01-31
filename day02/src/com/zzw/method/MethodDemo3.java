package com.zzw.method;

public class MethodDemo3 {
    public static void main(String[] args) {
        System.out.println("方法返回值演示:");

        // 调用没有返回值的方法
        checkAge(25);
        checkAge(-5);
    }

    // 在没有返回值方法中使用return提前结束方法
    public static void checkAge(int age) {
        if (age < 0) {
            System.out.println("年龄不能为负数");
            return; // 提前结束方法
        }
        System.out.println("年龄是: " + age);
    }


}
