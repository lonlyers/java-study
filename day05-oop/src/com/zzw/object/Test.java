package com.zzw.object;

public class Test {
    // 测试类
    public static void main(String[] args) {
        // 创建明星对象
        StarObject star1 = new StarObject();
        star1.name = "张三";
        star1.age = 25;
        star1.gender = "男";
        // 输出明星信息
        System.out.println("明星信息：");
        System.out.println("姓名：" + star1.name);
        System.out.println("年龄：" + star1.age);
        System.out.println("性别：" + star1.gender);

        // 创建多个明星对象
        StarObject star2 = new StarObject();
        star2.name = "李四";
        star2.age = 30;
        star2.gender = "女";

        StarObject[] stars = {star1, star2};
        // 计算并输出年龄总和和平均年龄
        StarObject.getAgeSumAndAvg(stars);
    }


}
