package com.zzw.method.example;

import java.util.Scanner;

public class CalcPeopleBMR {
    public static void main(String[] args) {
        calcBMR();
    }

    public static void calcBMR() {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("请输入您的体重(kg): ");
        double kg = sc.nextDouble();
        System.out.print("请输入您的身高(cm): ");
        double height = sc.nextDouble();
        System.out.print("请输入您的年龄(岁): ");
        int age = sc.nextInt();
        System.out.print("请输入您的性别(男/女): ");
        char gender = sc.next().charAt(0);
        double bmr;
        if (gender == '男') {
            bmr = (10 * kg) + (6.25 * height) - (5 * age) + 5;
        } else {
            bmr = (10 * kg) + (6.25 * height) - (5 * age) - 161;
        }
        System.out.printf("您的基础代谢率(BMR)是: %.2f 大卡/天\n", bmr);
    }

}
