package com.zzw.innerrclass;

// 外部类
public class Outer {
    // 静态内部类，有static修饰符，属于外部类自己持有
    public static class Inner {
        // 成员变量
        String name = "成员内部类name";

        // 成员方法
        public void show() {
            System.out.println("成员内部类show方法被调用");
        }
    }
    // 内部成员类。4
}
