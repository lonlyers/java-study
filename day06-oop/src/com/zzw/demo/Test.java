package com.zzw.demo;

import java.util.Scanner;

public class Test {
    // 多态的应用场景之一：加油卡案例
    public static void main(String[] args) {
        System.out.println("demo test");
        GoldCard card = new GoldCard("123456", "张xx", "123456789012345678", 5000);
        play(card);
        SilverCard sCard = new SilverCard("654321", "李xx", "987654321098765432", 3000);
        play(sCard);

    }
    // 认识多态的基本语法,
    public static void play(AyoubCard card) {
        System.out.println(
            "欢迎使用加油卡，请输入加油金额："
        );
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();
        card.jiaYou(money);
    }

}
