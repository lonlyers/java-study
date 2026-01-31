package com.zzw.branch;

public class SwitchDemo {
    public static void main(String[] args) {
        int day = 3;
        printDayOfWeek(day);
        String month = "4";
        printSeason(month);
    }

    // 使用switch语句根据数字打印对应的星期几,
    public static void printDayOfWeek(int day) {
        String dayName;
        switch (day) {
            case 1:
                dayName = "星期一";
                break;
            case 2:
                dayName = "星期二";
                break;
            case 3:
                dayName = "星期三";
                break;
            case 4:
                dayName = "星期四";
                break;
            case 5:
                dayName = "星期五";
                break;
            case 6:
                dayName = "星期六";
                break;
            case 7:
                dayName = "星期日";
                break;
            default:
                dayName = "无效的日期";
                break;
        }
        System.out.println("对应的日期是: " + dayName);
    }

    // switch的第二种用法示例,使用->直接接收结果不需要break，还可以使用,判断多个值
    public static void printSeason(String month) {
        String season = switch (month) {
            case "12", "1", "2" -> "冬季";
            case "3", "4", "5" -> "春季";
            case "6", "7", "8" -> "夏季";
            case "9", "10", "11" -> "秋季";
            default -> "无效的月份";
        };
        System.out.println("对应的季节是: " + season);
    }
}
