package com.zzw.extendsdemo;

public class Test {
    /*
    测试继承的使用，创建学生和教师对象
        1. 创建一个学生对象，设置姓名、年龄、学号，调用学习方法
        2. 创建一个教师对象，设置姓名、年龄、教授科目，调用教学方法
        3. 观察继承的效果
        4. 理解继承的好处：代码复用，提高代码的维护性
    */
    public static void main(String[] args) {
        // 创建一个学生对象,
        Student student = new Student();
        student.setName("李四");
        student.setAge(20);
        student.setStudentId("S12345");
        student.study(); // 调用学生的学习方法

        // 创建一个教师对象
        Teacher teacher = new Teacher();
        teacher.setName("王五");
        teacher.setAge(35);
        teacher.setSubject("数学");
        teacher.teach(); // 调用教师的教学方法
    }
}
