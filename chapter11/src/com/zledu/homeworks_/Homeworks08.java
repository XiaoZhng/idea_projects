package com.zledu.homeworks_;

public class Homeworks08 {
    public static void main(String[] args) {
        Color red = Color.RED;
        red.show();

        //switch不用写在color的show方法中判断，直接写在main方法中即可
        switch (red){
            case BLUE:
                System.out.println("蓝色");
                break;
            case RED:
                System.out.println("红色");
                break;
            case BLACK:
                System.out.println("黑色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            case YELLOW:
                System.out.println("黄色");
                break;
            default:
                System.out.println("没有匹配到颜色...");
        }
    }
}
enum Color implements IA{
    RED(255,0,0),BLUE(0,0,255),BLACK(0,0,0),
    YELLOW(255,255,0),GREEN(0,255,0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("属性值：" + redValue + "," + greenValue + "," + blueValue);
    }
}
interface IA{
    void show();
}