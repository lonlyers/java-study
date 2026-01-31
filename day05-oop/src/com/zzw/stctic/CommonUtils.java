package com.zzw.stctic;

public class CommonUtils {
    // 定义一个静态方法，用于交换两个整数的值

    // 注意：Java中的基本数据类型是按值传递的，因此无法直接交换两个整数变量的值。
    // 这里我们通过返回一个数组来实现交换效果。

    // 工具方法通常定义为静态方法，这样可以直接通过类名调用，而不需要创建类的实例。
    private CommonUtils() {
    }
    public static int[] swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        return new int[]{a, b};
    }

    // 定义一个静态方法，用于获取验证码有字符和数字组成
    public static String generateVerificationCode(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            code.append(chars.charAt(index));
        }
        return code.toString();
    }
}
