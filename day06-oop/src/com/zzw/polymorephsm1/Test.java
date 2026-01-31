package com.zzw.polymorephsm1;

public class Test {
    // 认识多态的基本语法
    public static void main(String[] args) {
        // 多态的前提：有继承/实现关系，有方法重写
        // 多态的格式：父类类型 变量名 = new 子类类型();
        // 多态的使用：当调用成员方法时，实际执行的是子类重写父类的方法
        // 多态的好处：提高了代码的扩展性
        // 多态的弊端：无法使用子类特有的方法/属性，可以使用强制类型转换解决,但可能出现ClassCastException异常,可以使用instanceof避免写法：变量名 instanceof 类名

        Animal a1 = new Dog();
        a1.eat(); // 狗吃骨头
//        a1.eatShift() 报错
        Dog d1 =  (Dog) a1; // 向下转型
        d1.eatShift(); // 狗吃屎

        System.out.println(a1.name); // 动物
        Animal a2 = new Cat();
        a2.eat(); // 猫吃鱼

        System.out.println(a2.name);   // 动物


    }

}
