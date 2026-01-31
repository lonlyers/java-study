package con.zzw.singleinstance;

public class B {
    // 认识单例模式（懒汉式单例）
    // 单例模式的应用场景：配置管理类、日志管理类、线程池管理类等

    // 定义一个静态变量保存唯一实例
    private static B instance;
    // 私有化构造方法，防止外部创建对象
    private B() {
    }
    // 提供一个公共的静态方法获取唯一实例
    public static B getInstance() {
        if (instance == null) {
            instance = new B();
        }
        return instance;
    }
}
