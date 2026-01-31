package con.zzw.finaldemo;

public class FinalDemo1 {
    // 认识final关键字，了解final的作用
    // final可以修饰类，方法，变量
    // 1、final修饰的类不能被继承
    // 2、final修饰的方法不能被重写
    // 3、final修饰的变量是一个常量，常量在定义时必须赋值，且赋值后不能修改
    public static void main(String[] args) {
        D d = new D();
        d.show();
        d.arr[1] = 200; // 虽然arr是final修饰的变量，但是arr指向的数组内容是可以修改的
        System.out.println("arr[1] = " + d.arr[1]);
    }
}

final  class  A {
    // final修饰的类不能被继承, 所以下面的B类不能继承A类
}
class B /* extends A */ {
    // final修饰的方法不能被重写,
    public final void method() {
        System.out.println("final method");
    }
}
class C extends B {
    // 下面的method方法不能被重写
//     public void method() {
//         System.out.println("override final method");
//     }
}
class D {
    // final修饰的变量是一个常量，常量在定义时必须赋值，且赋值后不能修改
    final int MAX_VALUE = 100;
     final int[] arr = {1,2,3};
    public void show() {
        // 下面的代码会报错，不能修改常量的值
        // MAX_VALUE = 200;
        System.out.println("MAX_VALUE = " + MAX_VALUE);
    }
}