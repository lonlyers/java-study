package con.zzw.interface1;

import java.util.zip.Inflater;

public class Demo {
    // 设计一个班级学生的信息管理模块。学生的数据有：姓名、性别、成绩
    // 需求1:要求打印出所有学生的信息
    // 需求2:要求打印出班级学生的平均成绩
    // 第一套方案：需求1和需求2 ，第二套方案；需求1+包含男女人数 ，需求2+要求去掉最高分和最低分的平均成绩
    public  static void main(String[] args) {
        Student[] students = new Student[6];
        students[0] = new Student("张三", "男", 85);
        students[1] = new Student("李四", "女", 92);
        students[2] = new Student("王五", "男", 78);
        students[3] = new Student("赵六", "女", 88);
        students[4] = new Student("钱七", "男", 95);
        students[5] = new Student("孙八", "女", 80);

        Print printA = new printStudentInfoA(students);
        printA.printStudentInfo();
        printA.printAverageScore();
        Print printB = new printStudentInfoB(students);
        printB.printStudentInfo();
        printB.printAverageScore();
    }
}

class Student {
    String name;
    String gender;
    int score;
    public Student(String name, String gender, int score) {
        this.name = name;
        this.gender = gender;
        this.score = score;
    }
}

class printStudentInfoA implements Print {
    Student[] students;
    public printStudentInfoA(Student[] students) {
        this.students = students;
    }


    @Override
    public void printStudentInfo() {
        // 实现打印学生信息的逻辑
        for (Student student : students) {
            System.out.println("姓名: " + student.name + ", 性别: " + student.gender + ", 成绩: " + student.score);
        }
    }

    @Override
    public void printAverageScore() {
        // 实现打印平均成绩的逻辑
        int totalScore = 0;
        for (Student student : students) {
            totalScore += student.score;
        }
        double averageScore = (double) totalScore / students.length;
        System.out.println("平均成绩: " + averageScore);
    }

}
class printStudentInfoB implements Print {
    Student[] students;
    public printStudentInfoB(Student[] students) {
        this.students = students;
    }

    @Override
    public void printStudentInfo() {
        // 实现打印学生信息的逻辑，包含男女生人数统计
        int maleCount = 0;
        int femaleCount = 0;
        for (Student student : students) {
            System.out.println("姓名: " + student.name + ", 性别: " + student.gender + ", 成绩: " + student.score);
            if (student.gender.equals("男")) {
                maleCount++;

            } else {
                femaleCount++;
            }
        }
        System.out.println("男生人数: " + maleCount + ", 女生人数: " + femaleCount);
    }
    @Override
    public void printAverageScore() {
        // 实现打印去掉最高分和最低分的平均成绩逻辑
        if (students.length <= 2) {
            System.out.println("学生人数不足，无法计算去掉最高分和最低分的平均成绩");
            return;
        }
        int totalScore = 0;
        int maxScore = Integer.MIN_VALUE;
        int minScore = Integer.MAX_VALUE;
        for (Student student : students) {
            totalScore += student.score;
            if (student.score > maxScore) {
                maxScore = student.score;
            }
            if (student.score < minScore) {
                minScore = student.score;
            }
        }
        double averageScore = (double) (totalScore - maxScore - minScore) / (students.length - 2);
        System.out.println("去掉最高分和最低分的平均成绩: " + averageScore);
    }
}


interface Print {
    void printStudentInfo();
    void printAverageScore();
}


