package com.zledu.homework;

public class Homework08 {
    public static void main(String[] args) {
        //枚举值的swich使用
        Color green = Color.RED;
        green.show();

        //switch()中，放入吗，枚举对象
        //在每个case后，直接写上枚举类中定义的枚举对象即可
        switch (green){
            case RED:
                System.out.println("匹配到红色");
                break;
            case BLUE:
                System.out.println("匹配到蓝色");
                break;
            default:
                System.out.println("没有匹配到颜色");
        }
    }
}

interface IMy {
    void show();
}

enum Color implements IMy {
    RED(255, 0, 0), BLUE(0, 0, 255),
    BLACK(0, 0, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0);
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
        System.out.println("属性值为：" + redValue + "," + greenValue + "," + blueValue);
    }
}