package con.zzw.interface2;

public interface MyInterface {
    // 认识接口的定义和使用
    void methodA();

    // 接口中的默认方法
    default void methodDefault() {
        System.out.println("接口中的默认方法");
    }

    // 接口中的静态方法
    static void methodStatic() {
        System.out.println("接口中的静态方法");
    }
    //
}