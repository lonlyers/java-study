package con.zzw.singleinstance;

public class Test {
    // 认识单例模式
    public static void main(String[] args) {
        A a1 = A.getInstance();
        A a2 = A.getInstance();

        System.out.println(a1 == a2); // true

        B b1 = B.getInstance();
        B b2 = B.getInstance();
        System.out.println(b1 == b2); // true
    }
}
