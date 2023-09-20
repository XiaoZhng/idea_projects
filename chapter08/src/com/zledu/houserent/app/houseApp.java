package com.zledu.houserent.app;

import com.zledu.houserent.view.houseView;

public class houseApp {
    public static void main(String[] args) {
        //创建houseView对象，并且显示主菜单，是整个程序的入口
        new houseView().mainMenu();//匿名函数直接调用houseView类中的mainMenu()
        System.out.println("----------程序退出！");
    }
}
