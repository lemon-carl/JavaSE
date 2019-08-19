package com.mg.rname.ui;

import javax.swing.*;

/**
 * @Auth CarlLing
 * @Date 2019/8/19 17:54
 * @Version 1.0
 * @Desc
 */
public class TestGUI {

    private static final String LABEL_SERVERNAME = "图片目录路径：";


    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
        JButton b = new JButton("一键秒对方基地挂");
        b.setBounds(50, 50, 280, 30);

        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
