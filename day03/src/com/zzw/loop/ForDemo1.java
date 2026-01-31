package com.zzw.loop;

public class ForDemo1 {
    // 掌握for循环的基本语法,理解for循环的执行流程
    public static void main(String[] args) {
        // 需求：打印5次"HelloWorld"
        for (int i = 1; i <= 3; i++) {
            System.out.println("HelloWorld");
        }
        getSum();
        getEven();
    }


    //求1-100之间所有整数的和
    public static void getSum(){
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }
    //输入1-10之前的所有偶数
    public static void getEven() {
        for (int i = 0; i <= 10; i+=2) {
            System.out.println(i);
        }
    }
}
