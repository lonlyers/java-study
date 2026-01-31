package com.zzw.hello;

public class HelloWold {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int randomInt = generateRandomInt(1, 100);
        System.out.println("随机生成的整数是: " + randomInt);
    }

    // 生成一个随机的整数，范围在min到max之间（包含min和max）

    public static int generateRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /*
     这是多行注释的示例
     可以用于解释代码的功能或提供额外的信息
     */
}
