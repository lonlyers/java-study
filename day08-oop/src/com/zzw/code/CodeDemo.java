package com.zzw.code;

public class CodeDemo {
    // 静态代码块,与类一起加载,且只执行一次
    // 一般用于初始化静态资源
    public static String school;
    public static void main(String[] args) {
        System.out.println("main方法被执行");
    }
    static {
        System.out.println("静态代码块被执行");
        school = "尚硅谷";
    }

}
