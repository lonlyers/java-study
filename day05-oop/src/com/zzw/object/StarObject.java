package com.zzw.object;

public class StarObject {
    // 创建一个明星类StarObject，包含明星的属性和行为
    // 属性：姓名、年龄、性别
    String name;
    int age;
    String gender;

    public static void  getAgeSumAndAvg(
            StarObject [] stars
    ){
        int sum = 0;
        double avg = 0;
        for (StarObject star : stars) {
            sum += star.age;
        }
        avg = (double) sum / stars.length;
        System.out.println("年龄总和为：" + sum);
        System.out.println("平均年龄为：" + avg);
    }
}
