package com.zzw.loop;

public class DoWhileDemo {
    // 掌握do...while循环的基本语法,理解do...while循环的执行流程
    public static void main(String[] args) {
        // 需求：打印5次"HelloWorld"
        int i = 1; // 初始化条件
        do { // 循环体
            System.out.println("HelloWorld");
            i++; // 迭代条件
        } while (i <= 5); // 循环条件
    }
}
