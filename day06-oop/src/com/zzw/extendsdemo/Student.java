package com.zzw.extendsdemo;

public class Student extends People{
    private String studentId; // 学号

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void study() {
        System.out.println("学生" + getName() + "正在学习，学号是：" + studentId);
    }
}
