package com.zzw.javabean;

public class Test {
    // 认识JavaBean类,理解JavaBean的规范,实体类
    // JavaBean类通常具有以下特点:
    // 1. 所有成员变量都使用private修饰,
    // 2. 提供公共的getter和setter方法来访问和修改成员变量,
    // 3. 提供一个无参构造器,
    public static void main(String[] args) {
        // 创建JavaBean类的对象
        Student student = new Student();
        // 使用setter方法设置属性值
        student.setName("李四");
        student.setAge(20);
        double[] scores = {85.5, 90.0, 78.5};
        student.setScores(scores);
        // 使用getter方法获取属性值,
        System.out.println("姓名：" + student.getName());
        System.out.println("年龄：" + student.getAge());
        //

        StudentOperator studentOperator = new StudentOperator(student);
        studentOperator.printStudentTotalAndAvgScore();
    }
}
