package com.zzw.demo;

public class GoldCard extends AyoubCard {

    public GoldCard(String carId, String carName, String phone, double endMoney) {
        super(carId, carName, phone, endMoney);
    }


    public void jiaYou(double money) {
        System.out.println("使用金卡支付，加油金额："+money);
        double finalMoney = money * 0.8;
        System.out.println("实际支付金额："+finalMoney);
        setEndMoney(getEndMoney() - finalMoney);
        System.out.println("剩余金额："+getEndMoney());
        if(finalMoney > 200) {
            printInfo();
        }else {
            System.out.println("本次加油未达到200元，无法打印信息");
        }
    }

    public void printInfo() {
        System.out.println("金卡信息：");
        System.out.println("车牌号："+getCarId());
        System.out.println("车主姓名："+getCarName());
        System.out.println("联系电话："+getPhone());
        System.out.println("余额："+getEndMoney());
    }
}
