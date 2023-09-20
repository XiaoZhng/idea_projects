package com.zledu.tanKgame2;

import javax.swing.*;

public class TankGame02 extends JFrame {

    private MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame02();
    }

    public TankGame02(){
        mp = new MyPanel();//初始化MyPanel
        this.add(mp);//把MyPanel(绘图区域)加入到窗口
        this.setSize(1000, 750);//窗口大小
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
