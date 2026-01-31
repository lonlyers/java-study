package com.zzw.example;

import java.util.Scanner;

public class TestDemo2 {

    // 猜数字游戏
    public static void main(String[] args) {
        guessNumberGame();
    }

    // 猜数字游戏的方法
    public static void guessNumberGame() {
        // 1. 生成一个1-100之间的随机整数
        int randomNumber = (int) (Math.random() * 100) + 1;
        // 2. 提示用户输入数字
        Scanner input = new Scanner(System.in);
        int userGuess = 0;
        System.out.println("请输入你猜的数字（1-100）：");
        // 3. 循环直到用户猜对为止
        while (userGuess != randomNumber) {
            userGuess = input.nextInt();
            if (userGuess < randomNumber) {
                System.out.println("太小了，请再试一次：");
            } else if (userGuess > randomNumber) {
                System.out.println("太大了，请再试一次：");
            } else {
                System.out.println("恭喜你，猜对了！");


            }
        }
    }
}
