package con.zzw.interface1;

public interface A {
    // 接口中的成员变量只能是常量，接口不能创建对象，接口是用来被类实现的（implements），实现接口的的类成为实现类，一个类可以实现多个接口
    // 1、常量：使用public static final修饰的变量,可以在接口中省略这些修饰符
    // Jdk8及以前：接口中的成员变量只能是常量，必须使用public static final修饰
    // Jdk9及以后：接口中允许定义私有的静态常量
    int NUM = 10;

    // 2、抽象方法：使用public abstract修饰的方法，可以在接口中省略这些修饰符
    // Jdk8及以前：接口中的方法只能是抽象方法
    void methodA();

}
