package com.zzw.branch;

public class IfDemo1 {
    public static void main(String[] args) {
        useIf(20);

    }

    // if语句的基本使用
    public static void useIf(int age) {

        if (age >= 18) {
            System.out.println("您已成年，可以投票。");
        } else {
            System.out.println("您未成年，不能投票。");
        }
    }
}
