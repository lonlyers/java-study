package con.zzw.eumndemo;

public class Test2 {
    // 枚举类的应用场景
    public static void main(String[] args) {
        // 使用枚举类表示星期
        Weekday today = Weekday.WEDNESDAY;
        System.out.println("今天是: " + today);

        // 使用枚举类表示交通信号灯
        TrafficLight signal = TrafficLight.RED;
        System.out.println("当前信号灯是: " + signal);

        // 根据今天的星期，给出活动建议
        suggestActivity(Weekday.MONDAY);
    }

    // 枚举类的使用场景总结
    /*
     * 1. 表示一组固定的常量值，如星期、月份、交通信号灯等。
     * 2. 提高代码的可读性和可维护性，避免使用魔法数字或字符串。
     * 3. 提供类型安全，防止传入无效的值。
     * 4. 方便与switch语句结合使用，简化条件判断逻辑。
     */
    // End of enum usage scenarios
    // 根据传入的星期值，返回对应的活动建议
    public static void suggestActivity(Weekday day) {
        switch (day) {
            case MONDAY:
                System.out.println("开始新的一周，制定计划！");
                break;
            case WEDNESDAY:
                System.out.println("周三了，继续努力！");
                break;
            case FRIDAY:
                System.out.println("周五了，准备放松一下！");
                break;
            case SUNDAY:
                System.out.println("周日休息，准备迎接新的一周！");
                break;
            default:
                System.out.println("工作日，加油！");
                break;
        }
    }
}

