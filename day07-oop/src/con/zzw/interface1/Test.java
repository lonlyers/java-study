package con.zzw.interface1;

public class Test {
    // 认识接口
    public static void main(String[] args) {
        // 接口不能实例化
        // MyInterface mi = new MyInterface(); // 错误写法
        // 接口的实现类可以实例化
        //  接口的好处：1.接口可以被多实现 2.接口可以被多态引用·
        A a = new C();
        a.methodA();
        B b = new C();
        b.methodB();
        C c = new C();
        c.methodA();
        c.methodB();
    }
}

// C为实现类，实现类实现了A和B接口，必须重写接口中的所有抽象方法，否则这个类必须定义为抽象类
class  C implements A, B {
    @Override
    public void methodA() {

    }

    @Override
    public void methodB() {

    }
}