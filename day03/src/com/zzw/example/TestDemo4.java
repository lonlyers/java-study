package com.zzw.example;

public class TestDemo4 {
    // 找素数
    public static void main(String[] args) {
        findPrimeNumber(20);
    }
    // 找一个1-n之间的素数
    public static void findPrimeNumber(int max) {
        for (int i = 1; i <= max; i++) {
            if(isPrimeNumber(i)) {
                System.out.println(i + "是素数");
            }
        }
    }
    // 判断一个数是否是素数
    public static boolean isPrimeNumber(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
