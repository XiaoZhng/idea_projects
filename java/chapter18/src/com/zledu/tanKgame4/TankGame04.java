package com.zledu.tanKgame4;

import javax.swing.*;

public class TankGame04 extends JFrame {

    private MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame04();
    }

    public TankGame04(){
        mp = new MyPanel();//初始化MyPanel
        //启动MyPanel线程，让子弹重绘
        new Thread(mp).start();
        this.add(mp);//把MyPanel(绘图区域)加入到窗口
        this.setSize(1200, 1200);//窗口大小
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
