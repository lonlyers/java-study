package com.zzw.method.operator;

public class OperatorDemo1 {

    public static void main(String[] args) {
        System.out.println("算术运算符演示:");
        demonstrateArithmeticOperators();
    }

    // 演示基本的算术运算符
    public static void demonstrateArithmeticOperators() {
        int a = 15;
        int b = 4;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("加法 (a + b): " + (a + b));
        System.out.println("减法 (a - b): " + (a - b));
        System.out.println("乘法 (a * b): " + (a * b));
        System.out.println("除法 (a / b): " + (a / b));
        System.out.println("取模 (a % b): " + (a % b));
        System.out.println("自增 (a++): " + (a++));
        System.out.println("自减 (b--): " + (b--));
        System.out.println(a);
        System.out.println(b);
        System.out.println("--a:" + (--a));
        System.out.println("++b: " + (++b));
    }
}
