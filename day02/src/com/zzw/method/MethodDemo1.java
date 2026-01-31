package com.zzw.method;

public class MethodDemo1 {
    public static void main(String[] args) {

        greetUser("Alice");
        int sum = addNumbers(5, 10);
        System.out.println("5 + 10 = " + sum);
        String code = checkCode(6);
        System.out.println("生成的6位验证码是: " + code);

        printParams(42);
        printParams("Hello Method");
        printParams(true);
    }

    // 打招呼的方法
    public static void greetUser(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // 两数相加的方法
    public static int addNumbers(int a, int b) {
        return a + b;
    }

    // 获取一个指定位数的验证码

    public static String checkCode(int length) {
        String code = "";
        for (int i = 0; i < length; i++) {
            int digit = (int) (Math.random() * 10);
            code += digit;
        }
        return code;
    }

    // 方法重载
    public static void printParams(int a) {
        System.out.println("整数参数: " + a);
    }
    public static void printParams(String s) {
        System.out.println("字符串参数: " + s);
    }

    public static  void printParams(boolean b) {
        System.out.println(b);
    }

}
