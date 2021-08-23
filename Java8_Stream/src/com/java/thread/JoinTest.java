package com.java.thread;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName : JoinTest
 * Created with IDEA
 * @author:CarlLing
 * @CreateDate : 2018-11-03 14:19
 * @Description : 线程的加入
 * join方法实现 两条进度条，使上面的进度条必须等待下面的进度完成才可以继续进行
 */
public class JoinTest extends JFrame {

    private Thread threadA;
    private Thread threadB;

    final JProgressBar progressBar = new JProgressBar();
    final JProgressBar progressBar2 = new JProgressBar();
    int count = 0;

    public JoinTest() {
        super();
        getContentPane().add(progressBar, BorderLayout.NORTH);
        getContentPane().add(progressBar2, BorderLayout.SOUTH);
        progressBar.setStringPainted(true);
        progressBar2.setStringPainted(true);
        threadA = new Thread(new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    progressBar.setValue(++count);
                    try {
                        Thread.sleep(100);
                        threadB.join();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA.start();
        threadB = new Thread(new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    progressBar2.setValue(++count);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (count == 100)
                        break;

                }
            }
        });
        threadB.start();
    }


    public static void main(String[] args) {
        init(new JoinTest(), 100, 100);
    }

    public static void init(JFrame frame, int width, int height) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

}
