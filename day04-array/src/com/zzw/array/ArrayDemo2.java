package com.zzw.array;

import java.util.Arrays;

public class ArrayDemo2 {

    // 认识二维数组的定义和使用
    public static void main(String[] args) {
        // 定义一个二维数组
        int[][] arr = new int[3][4]; // 3行4列的
        // 给二维数组赋值,
        String[][] names = {
                {"张三", "李四", "王五"},
                {"赵六", "钱七", "孙八"},
                {"周九", "吴十", "郑十一"}
        };
        // 访问二维数组中的元素
        for (String[] name : names) {
            for (String s : name) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        // 调用方法,定义一个n*n的二维数组,内容从1递增填充,并打印
        arrayDemo(4);

    }
    // 定义一个二维数组n*n,内容从1递增填充,并打印
    public static void arrayDemo(int n){
        int[][] arr = new int[n][n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = num++;
            }
        }

        // 打乱二维数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = (int)(Math.random() * n);;
                int y = (int)(Math.random() * n);
                // 交换arr[i][j]和arr[x][y]
                int temp = arr[i][j];
                arr[i][j] =  arr[x][y];
                arr[x][y] = temp;
            }
        }

        // 打印二维数组
       System.out.println(Arrays.deepToString(arr));
    }
}
