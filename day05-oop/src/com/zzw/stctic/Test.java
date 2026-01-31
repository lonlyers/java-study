package com.zzw.stctic;

public class Test {
    // 认识static关键字，理解static的使用
    public static void main(String[] args) {
        // 创建两个学生对象
        Student s1 = new Student("李四", 20);
        Student s2 = new Student("王五", 22);
        // 调用方法显示信息
        s1.showInfo();
        s2.showInfo();
        // 修改学校名称
        Student.schoolName = "新学校名称";
        System.out.println("修改学校名称后：");
        // 再次调用方法显示信息
        s1.showInfo();
        s2.showInfo();

        String code = CommonUtils.generateVerificationCode(6);
        System.out.println("生成的验证码是：" + code);
    }
}
