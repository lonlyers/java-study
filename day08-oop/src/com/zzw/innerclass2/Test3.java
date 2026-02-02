package com.zzw.innerclass2;
import java.util.Arrays;

public class Test3 {

    public  static void main(String[] args) {
        // 使用匿名内部类,完成数组排序
        // 需求:准备一个学生类数组，存放六个学生对象
        Student[] students = new Student[6];
        students[0] = new Student("张三",23);
        students[1] = new Student("李四",21);
        students[2] = new Student("王五",25);
        students[3] = new Student("赵六",22);
        students[4] = new Student("钱七",24);
        students[5] = new Student("孙八",20);
        // 按照年龄进行升序排序
        Arrays.sort(students,(Student s1, Student s2) -> {
            return s1.getAge() - s2.getAge();
        });

        // 遍历输出排序后的学生信息
        for (Student student : students) {
            System.out.println(student.getName() + "----" + student.getAge());
        }
    }
}
