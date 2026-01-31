package com.zzw.javabean;

public class StudentOperator {
    // 成员方法
    private Student student;
    // 打印学生信息
    public StudentOperator() {

    }
    public StudentOperator(Student student) {
        this.student = student;
    }
    public void printStudentInfo(Student stu) {
        System.out.println("学生信息如下：");
        System.out.println("姓名：" + stu.getName());
        System.out.println("年龄：" + stu.getAge());
        System.out.println("性别：" + stu.getGender());
    }
    // 打印学生总分和平均分
    public void printStudentTotalAndAvgScore() {
        double totalScore = 0.0;
        double[] scores = student.getScores();
        for (double score : scores) {
            totalScore += score;

        }
        double avgScore = totalScore / scores.length;
        System.out.println("总分：" + totalScore);
        System.out.println("平均分：" + avgScore);
    }
}
