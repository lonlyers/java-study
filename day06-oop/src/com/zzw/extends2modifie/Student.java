package com.zzw.extends2modifie;

public class Student {
    private String studentId; // 学号
    public String name; // 姓名
    private int age; // 年龄
    protected double score;
    private String grade;
    String address; // 地址，默认权限
    String phone;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void study() {
        System.out.println("学生正在学习，学号是：" + studentId);
    }

    public  void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public  void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
}
