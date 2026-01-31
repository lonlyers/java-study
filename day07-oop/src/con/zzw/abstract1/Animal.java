package con.zzw.abstract1;

public abstract class Animal {
    // 抽象方法
    public abstract void eat();

    // 非抽象方法
    public void sleep() {
        System.out.println("动物睡觉");
    }
}
