package com.zzw.example;

public class TestDemo3 {
    //
    public static void main(String[] args) {
        String code = checkCode(6);
        System.out.println("随机验证码是：" + code);

    }
    public static String checkCode(int length) {
        String code = "";
        // 生成length位的随机验证码，包含数字和字母
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * 62);
            if (rand < 10) {
                code += (char) ('0' + rand);
            } else if (rand < 36) {
                code += (char) ('A' + rand - 10);
            } else {
                code += (char) ('a' + rand - 36);
            }
        }
        return code;
    }
}
