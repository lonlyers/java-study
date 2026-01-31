package com.zzw.method.example;

import java.util.Scanner;

public class CalcPeopleBMI {
    public static  void main(String[] args) {
        calcBMI();
    }

    public  static  void calcBMI() {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入您的体重(kg): ");
        double kg = sc.nextDouble();
        System.out.print("请输入您的身高(m): ");
        double weight = sc.nextDouble();

        double bmi = kg / (weight * weight);

        System.out.printf("您的BMI指数是: %.2f\n", bmi);
        if (bmi < 18.5) {
            System.out.println("体重过轻");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("体重正常");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("超重");
        }  else {
            System.out.println("肥胖");
        }

    }
}
