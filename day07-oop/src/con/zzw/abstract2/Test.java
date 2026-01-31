package con.zzw.abstract2;

public class Test {
    // 目标：理解抽象类的使用场景二：模板方法设计模式。
    public static void main(String[] args) {
        // 制作红豆豆浆
        System.out.println("===制作红豆豆浆===");
        SoyMilk redBeanSoyMilk = new RedBeanSoyMilk();
        redBeanSoyMilk.make();
        System.out.println("\n===制作花生豆浆===");
        SoyMilk peanutSoyMilk = new PeanutSoyMilk();
        peanutSoyMilk.make();
    }
}
