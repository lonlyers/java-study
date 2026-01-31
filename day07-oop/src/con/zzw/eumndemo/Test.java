package con.zzw.eumndemo;

public class Test {
    // 认识枚举类的使用
    public static void main(String[] args) {
        // 使用枚举类
        Season spring = Season.SPRING;
        Season summer = Season.SUMMER;
        Season autumn = Season.AUTUMN;
        Season winter = Season.WINTER;
        System.out.println("春天: " + spring);
        System.out.println("夏天: " + summer);
        System.out.println("秋天: " + autumn);
        System.out.println("冬天: " + winter);
        System.out.println(Season.values());
    }
}
