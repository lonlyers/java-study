package com.zzw.method;

public class MethodDemo2 {
    // 主方法
    public static void main(String[] args) {
        System.out.println("方法演示:");
        displayInfo("John");
        displayInfo(25);
        displayInfo("Alice", 30);
        int sum = displayInfo(10, 20);
        System.out.println("Sum: " + sum);
    }

    // 定义重载的方法
    public static void displayInfo(String name) {
        System.out.println("Name: " + name);
    }
    public static void displayInfo(int age) {
        System.out.println("Age: " + age);
    }
    public static void displayInfo(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static int displayInfo(int a, int b) {
        return a + b;
    }
}
