package com.zledu.fwcz.service;

import com.zledu.fwcz.domain.house;

public class houseService {
    private house[] houses;//存储房屋信息
    private int houseNum = 1;//记录数组中房屋的数量
    private int idCloud = 1;//记录id自增

    public houseService(int size){
        //当创建一个houseService对象时，指定数组大小
        houses = new house[size];
        //定义一个初始对象
        houses[0] = new house(1, "jack", "123", "青秀区", 1500, "未出租");
    }
    //编写list(),返回数组信息
    public house[] list(){
        return houses;
    }

    //编写add()，添加房屋信息
    public boolean add(house newHouse){
        //先判断还能不能添加房屋信息
        if (houseNum == houses.length){
            System.out.println("房屋信息已满，不能添加");
            return false;
        }
        //如果数组没满，则可以添加
        houses[houseNum++] = newHouse;

        //id自增
        //先+1再自增
        newHouse.setId(++idCloud);
        return true;
    }

    //编写del()，删除房屋信息
    public boolean del(int delId){
        int index = -1;
        //先遍历数组中
        for (int i = 0; i < houseNum; i++) {
            //判断是否有要删除的id所对应的数组
            //如果有就把所对应的下标赋给index
            if (delId == houses[i].getId()){
                index = i;
            }
        }
        if (index == -1){ //index =-1就说明没找到
            return false;
        }
        //如果找到了
            //就把删除的数组 的后面一个数组移到前面，把要删除的数组移到最后，设置为null
        for (int i = index; i < houseNum - 1; i++) {
            houses[i] = houses[i+1];
        }
        houses[--houseNum] = null;//先-1再自减
        return true;
    }

    //编写find()，查找房屋信息
    public house find(int findId){
        //先遍历数组，看看是否能找到对应的id
        for (int i = 0; i < houseNum; i++) {
            //查找id = 遍历数组中的id时，返回该数组对象
            if (findId == houses[i].getId()){
                return houses[i];
            }
        }
        //没有找到返回null
        return null;
    }
}
