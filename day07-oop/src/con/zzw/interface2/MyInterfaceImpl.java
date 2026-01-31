package con.zzw.interface2;

public class MyInterfaceImpl implements MyInterface {
    // 实现类必须重写接口中的所有抽象方法
    public void methodA() {
        System.out.println("实现类重写了methodA方法");
    }

    public void methodB() {
        System.out.println("实现类重写了methodB方法");
    }
}
