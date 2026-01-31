package com.zzw.method;

public class MethodDemo4 {
    public static void main(String[] args) {
        typeConversion();
    }
    // java中的类型转换
    public static void typeConversion() {
        int intValue = 100;
        double doubleValue = intValue; // 自动类型转换
        System.out.println("整数转换为双精度: " + doubleValue);
        double anotherDouble = 99.99;
        int anotherInt = (int) anotherDouble; // 强制类型转换
        System.out.println("双精度转换为整数: " + anotherInt);
    }
}
