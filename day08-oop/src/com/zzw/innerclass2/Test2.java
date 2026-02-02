package com.zzw.innerclass2;

import javax.swing.*;



public class Test2 {
    public static void main(String[] args) {
        // 创建一个登录窗口，窗口上只有一个按钮
        JFrame frame = new JFrame();
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("登录");
        frame.add(button);
        // 给按钮注册一个监听器(事件处理器)
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "登录成功！");
        });
        frame.setVisible(true);
    }
}
