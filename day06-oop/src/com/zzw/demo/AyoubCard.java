package com.zzw.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 自动生成getter/setter/toString等方法
@AllArgsConstructor // 自动生成包含所有参数的构造方法
@NoArgsConstructor // 自动生成无参构造方法
public class AyoubCard {
    private String carId;
    private String carName;
    private String phone;
    private double endMoney;



    //储存金额
    public void saveMoney(double money) {
        this.endMoney += money;
    }
    //加油
    public void jiaYou(double money) {
        if (money <= this.endMoney) {
            this.endMoney -= money;
            System.out.println("加油成功，加油金额：" + money + "，剩余金额：" + this.endMoney);
        } else {
            System.out.println("余额不足，加油失败！");
        }
    }
}
