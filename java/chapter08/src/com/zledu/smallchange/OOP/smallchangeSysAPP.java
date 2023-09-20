package com.zledu.smallchange.OOP;

/*
* 这里直接调用smallchangeSysOOP对象，显示主菜单即可
* */

public class smallchangeSysAPP {
    public static void main(String[] args) {
        //mainMenu为smallchangeSysOOP对象中的主菜单方法
        //里面调用四个功能，所以就只用调用mainMenu即可
        new smallchangeSysOOP().mainMenu();
    }
}
