package com.zzw.loop;

public class WhileDemo {
    // 掌握while循环的基本语法,理解while循环的执行流程
    public static void main(String[] args) {
        // 需求：打印5次"HelloWorld"
        int i = 1; // 初始化条件
        while (i <= 5) { // 循环条件
            System.out.println("HelloWorld");
            i++; // 迭代条件
        }
        getSum();
        getEven();
        demo();
        demo2();
    }
    //求1-100之间所有整数的和
    public static void getSum() {
        int sum = 0;
        int i = 1; // 初始化条件
        while (i <= 100) { // 循环条件
            sum += i;
            i++; // 迭代条件
        }
        System.out.println("sum = " + sum);
    }
    //输入1-10之前的所有偶数
    public static void getEven() {
        int i = 0; // 初始化条件
        while (i <= 10) { // 循环条件
            System.out.println(i);
            i += 2; // 迭代条件
        }
    }

    //
    public  static void demo(){
        double money = 100000; // 初始金额
        int year = 0; // 存款年数
        while (money < 200000){
            money *= 1.03; // 每年利息3%
            year++;
        }
        System.out.println("存款翻倍所需年数为：" + year);
    }
    //
    public  static void demo2(){
        int height= 8844430; // 初始高度，单位毫米
        double addHeight =  0.1;
        double num = 0;
        while (addHeight < height){
            addHeight = addHeight *2;
            num++;
        }
        System.out.println("折叠的次数为：" + num);
    }
}
