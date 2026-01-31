package con.zzw.singleinstance;

public class A {
    //认识单例模式（饿汉式单例）
    // 单例模式的应用场景：配置管理类、日志管理类、线程池管理类等

    // 定义一个静态常量保存唯一实例
    private static final A instance = new A();
    // 私有化构造方法，防止外部创建对象
    private A() {
    }
    public static A getInstance() {
        return instance;
    }
}
