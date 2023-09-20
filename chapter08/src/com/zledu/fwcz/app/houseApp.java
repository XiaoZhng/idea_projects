package com.zledu.fwcz.app;

import com.zledu.fwcz.view.houseView;

/**
 * houseApp.java[主方法](app类)
 * 1.调用houseView.java，创建一个houseVise对象，调用主菜单方法，显示主菜单
 * 2.房屋出租系统的程序入口
 */
public class houseApp {
    public static void main(String[] args) {
        new houseView().mainMenu();
        System.out.println("程序退出------");
    }
}
