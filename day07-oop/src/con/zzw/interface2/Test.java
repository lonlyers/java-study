package con.zzw.interface2;

public class Test {
    public static void main(String[] args) {
        // 创建实现类对象
        MyInterfaceImpl impl = new MyInterfaceImpl();
        // 调用接口中的抽象方法
        impl.methodA();
        impl.methodB();
        // 调用接口中的默认方法
        impl.methodDefault();
        // 调用接口中的静态方法
        MyInterface.methodStatic();
    }
}
