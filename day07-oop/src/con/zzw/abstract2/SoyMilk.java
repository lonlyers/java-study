package con.zzw.abstract2;

public abstract class SoyMilk {
    // 制作豆浆的模板方法
    public final void make(){
        makeSoy();
        System.out.println("第三步：过滤渣滓");
        System.out.println("第四步：煮豆浆");
    };

    public abstract void makeSoy();
}
