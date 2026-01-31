package com.zzw.extendsdemo;

public class Teacher extends People {
    private String subject; // 教授的科目

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void teach() {
        System.out.println("教师" + getName() + "正在教授" + subject);
    }
}
