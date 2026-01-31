package com.zzw.method.scanner;
import  java.util.Scanner;

public class ScannerDemo1 {
    public static void main(String[] args) {
        System.out.println("Scanner类的使用演示:");
        useScanner();
    }

    // 使用Scanner类获取用户输入
    public static void useScanner() {
        // 导入Scanner类
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入一个整数
        System.out.print("请输入一个整数: ");
        int intValue = scanner.nextInt();
        System.out.println("您输入的整数是: " + intValue);

        // 提示用户输入一个浮点数
        System.out.print("请输入一个浮点数: ");
        double doubleValue = scanner.nextDouble();
        System.out.println("您输入的浮点数是: " + doubleValue);

        // 提示用户输入一个字符串
        System.out.print("请输入一个字符串: ");
        String stringValue = scanner.next();
        System.out.println("您输入的字符串是: " + stringValue);

        // 关闭Scanner对象
        scanner.close();
    }
}
