package com.zzw.innerrclass;

public class InnerClassDemo1 {
   public static void main(String[] args) {
        // 创建外部类对象
        Outer outer = new Outer();
        // 通过外部类对象创建成员内部类对象
        Outer.Inner inner = new Outer.Inner();
        // 调用成员内部类的方法
        inner.show();
        // 访问成员内部类的成员变量
        System.out.println("成员内部类的name属性值是：" + inner.name);
    }
}
