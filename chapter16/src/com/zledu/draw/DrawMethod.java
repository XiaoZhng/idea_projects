package com.zledu.draw;

import javax.swing.*;
import java.awt.*;

public class DrawMethod extends JFrame{

    private Panel mp = null;//定义一个画板
    public static void main(String[] args) {
        new DrawMethod();
    }

    public DrawMethod(){
        mp = new Panel();//初始化画板
        this.add(mp);//把面板加入到窗口
        this.setSize(500, 500);//定义窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击窗口小×关闭程序
        this.setVisible(true);//可视化，可以显示
    }
}
class Panel extends JPanel {//面板
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //画椭圆边框：drawOval(int x, int y, int width, int height)
        //g.drawOval(10, 10, 100, 100);

        //画直线：drawLine(int x1, int y1, int x2, int y2)
        //g.drawLine(100, 100, 200, 200);

        //画矩形边框：drawRect(int x, int y, int width, int height)
        //g.drawRect(50, 50, 100, 100);

        //填充矩形：fillRect(int x, int y, int width, int height)
        //填充颜色：setColor(Color.颜色)
        //g.setColor(Color.red);
        //g.fillRect(50, 50, 100, 100);

        //填充椭圆：fillOval(int x, int y, int width, int height)
        //填充颜色：setColor(Color.颜色)
        //g.setColor(Color.blue);
        //g.fillOval(50, 50, 100, 100);

        //画图片：drawImage(Image img, int x, int y)
        //获取图片资源：Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/2021-12-25_164106.jpg"))
        ///2021-12-25_164106.jpg：表示在该项目的根目录去获取 2021-12-25_164106.jpg 图片资源
        //Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/2021-12-25_164106.jpg"));
        //g.drawImage(image, 100, 100, 300, 150, this);

        //画字符串：drawString(String str, int x, int y)
        //设置画笔字体：setFont(new Font(字体, 字体深度, 字体大小))
        setFont(new Font("隶书", Font.BOLD, 50));
        g.setColor(Color.blue);
        g.drawString("hello world", 100, 100);//xy坐标位置在左下角
    }
}