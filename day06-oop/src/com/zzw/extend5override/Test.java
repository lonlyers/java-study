package com.zzw.extend5override;

public class Test {
    // 方法重写Override的使用
    public static void main(String[] args) {
        Animal a1 = new Animal();
        a1.eat(); // 动物吃东西
        Dog d1 = new Dog();
        d1.eat(); // 狗吃骨头
        // 创建学生对象
        Student s1 = new Student("张三", 18);
        System.out.println(s1); // Student{name='张三', age=18}
    }
}

class  Animal {
    public Animal(){
        System.out.println('1');
    }

    public void eat() {
        System.out.println("动物吃东西");
    }
}
class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showInfo() {
        System.out.println("姓名：" + name + "，年龄：" + age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}