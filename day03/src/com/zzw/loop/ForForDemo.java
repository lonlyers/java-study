package com.zzw.loop;

public class ForForDemo {
    // 嵌套for循环
    // 打印5行5列的星星
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) { // 控制行数
            for (int j = 1; j <= 5; j++) { // 控制列数
                System.out.print("* ");
            }
            System.out.println(); // 换行
        }
        multiplicationTable();
    }

    // 打印99乘法表
    public static void multiplicationTable() {

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }

            System.out.println(); // 换行
        }
    }
}
