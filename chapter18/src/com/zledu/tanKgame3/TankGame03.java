package com.zledu.tanKgame3;

import javax.swing.*;

public class TankGame03 extends JFrame {

    private com.zledu.tanKgame3.MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame03();
    }

    public TankGame03(){
        mp = new MyPanel();//初始化MyPanel
        //启动MyPanel线程，让子弹重绘
        new Thread(mp).start();
        this.add(mp);//把MyPanel(绘图区域)加入到窗口
        this.setSize(1000, 750);//窗口大小
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
