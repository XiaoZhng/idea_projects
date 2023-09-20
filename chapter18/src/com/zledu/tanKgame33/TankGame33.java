package com.zledu.tanKgame33;

import javax.swing.*;

public class TankGame33 extends JFrame {

    private MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame33();
    }

    public TankGame33(){
        //因为 MyPanel是一个线程，所以要启动线程
        mp = new MyPanel();//初始化MyPanel
        new Thread(mp).start();//启动线程
        this.add(mp);//把MyPanel(绘图区域)加入到窗口
        this.setSize(1200, 850);//窗口大小
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
