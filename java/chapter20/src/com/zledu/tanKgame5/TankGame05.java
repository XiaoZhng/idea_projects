package com.zledu.tanKgame5;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Reader;
import java.util.Scanner;

public class TankGame05 extends JFrame {

    private MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        new TankGame05();
    }

    public TankGame05(){
        System.out.println("请输入1:新游戏 2:继续上局");
        String key = scanner.next();
        mp = new MyPanel(key);//初始化MyPanel
        //启动MyPanel线程，让子弹重绘
        new Thread(mp).start();
        this.add(mp);//把MyPanel(绘图区域)加入到窗口
        this.setSize(1300, 1200);//窗口大小
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //在JFrame 中添加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
