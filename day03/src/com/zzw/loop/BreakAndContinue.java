package com.zzw.loop;

public class BreakAndContinue {

    // break和continue关键字的使用,
    public static void main(String[] args) {
        // 需求：打印1-10之间所有的整数，遇到5时跳出循环
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            if (i == 5) {

                break; // 跳出循环
            }
        }
        System.out.println("=========");
        // 需求：打印1-10之间所有的整数，遇到5时跳过5继续打印
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue; // 跳过本次循环，继续下一次循环
            }
            System.out.println(i);
        }
    }
}
