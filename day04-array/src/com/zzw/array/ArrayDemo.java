package com.zzw.array;

import java.util.Arrays;

public class ArrayDemo {

    // 数组的定义和使用
    public static void main(String[] args) {
        // 定义一个存储5个整数的数组
        int[] arr = new int[5];
        // 给数组赋值
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;
        // 获取数组的长度
        System.out.println("数组的长度为: " + arr.length);
        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("数组arr2的长度为: " + arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("arr2[" + i + "] = " + arr2[i]);
        }
        print();

        classNames();

        heights();

        int[] arr3 = {1, 2, 3, 4, 5};
        sumArray(arr3);

        int[] arr4 = {1, 2, 3, 4, 5,6};
        countDivisibleBy3(arr4);

        transformArray(arr4);

        getMaxAndMin(arr4);

        reverseArray(arr4);
    }

    // 定义数组，存储5个学生的年龄
    public  static void print() {
        int[] ages = {
            18, 19, 20, 21, 22
        };
        System.out.println(Arrays.toString(ages));
    }

    // 定义数组，存储3个班级的名称
    public static void classNames() {
        String[] classNms = new String[3];
        classNms[0] = "一班";
        classNms[1] = "二班";
        classNms[2] = "三班";
        System.out.println(Arrays.toString(classNms));

    }

    // 定义数组，存储4个学生的身高
    public static void heights() {
        double[] heights = {170.5, 180.2, 175.0, 160.8};
        System.out.println(Arrays.toString(heights));
    }

    // 数组内容求和
    public  static void sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("数组元素的和为: " + sum);

    }

    // 根据传入的数据找出能被3整除的个数，分别是
    public static void countDivisibleBy3(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 0) {
                System.out.println(arr[i]);
                count++;
            }
        }
        System.out.println("能被3整除的个数为: " + count);
    }

    // 传入一个数组，如果为奇数则*2，否则/2，返回新数组
    public static void transformArray(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                newArr[i] = arr[i] * 2;
            } else {
                newArr[i] = arr[i] / 2;
            }
        }
        System.out.println("转换后的数组为: " + Arrays.toString(newArr));
    }
    // 求数组的最大值和最小值
    public  static void getMaxAndMin(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("数组的最小值为: " + min);
        System.out.println("数组的最大值为: " + max);
    }

    // 交换数组的顺序
    public static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println("反转后的数组为: " + Arrays.toString(arr));
    }
}
