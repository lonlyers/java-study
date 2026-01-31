package com.zzw.example;

import java.util.Scanner;

public class TestDemo1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        calculator();
    }

    public static void calculator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个整数:");
        double a = sc.nextDouble();
        System.out.println("请输入第二个整数:");
        double b = sc.nextDouble();
        System.out.println("请输入运算符 (+, -, *, /):");
        String operator = sc.next();
        double result;
        result = calc(a, b, operator);
        System.out.println("结果是: " + result);
        sc.close();

    }

    public static double calc(double a, double b, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b != 0) {
                    result = a / b;
                } else {
                    System.out.println("错误: 除数不能为零");
                }
                break;
            default:
                System.out.println("错误: 无效的运算符");
        }
        return result;

    }
}

