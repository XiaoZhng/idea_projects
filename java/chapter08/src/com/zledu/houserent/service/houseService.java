package com.zledu.houserent.service;

import com.zledu.houserent.domain.house;

/**
 * houseService.java [业务层]
 * 定义House[],保存House对象
 * 1.响应houseView的调用
 * 2.完成对房屋信息的各种操作[增删改查]
 */
public class houseService {
    private house[] houses; //保存House对象
    private int houseNum = 1;//记录数组中的房屋信息个数 因为house有一个初始化对象，所以初始值为1
    private int idCounter = 1;//记录数组中id添加到哪个值

    //在构造器中指定数组的大小
    public houseService(int size){
        houses = new house[size]; //当创建houseService对象，指定数组大小
        //为了配合测试列表信息，这里初始化一个house对象
        houses[0] = new house(1, "jack", "111", "青秀区", 1500, "未出租");
    }
    //创建一个list方法，返回houses
    public house[] list(){
        return houses;
    }

    //编写方法add(house newHouse),把新的house对象加入到houses数组,返回boolean
    public boolean add(house newHouse){
        //判断数组是否可以继续添加
        if (houseNum == houses.length){//如果房屋信息个数等于数组长度则不能添加,返回false
            System.out.println("数组已满，不能再添加了!");
            return false;
        }
        //理解：数组可以添加的情况下,执行下面代码
        //housesNum=1，houses[1] 新添加的数组为newHouse，赋给houses[1]
        //因为houses[]已经有一个信息了，所以下一个信息添加位置为1，正好就是houseNum，然后添加完再+1
        houses[houseNum++] = newHouse;
        //需要设计一个id自增长的机制,然后更新newHouse的id
        //新添加的数组newHouse更新id,添加一个更新一个,set()
        newHouse.setId(++idCounter);
        return true;
    }

    public boolean del(int delId){
        //先找到数组中要删除的房屋编号
        //下标和房屋编号不是一回事
        int index = -1;
        //先把数组变量,因为houseNum是记录房屋信息个数，所以不需要再写houses.length
        for (int i = 0; i < houseNum; i++) {
            //判断如果要删除的房屋编号 == 删除房屋下标所对应的id时
            if (delId == houses[i].getId()){
                index = i;//就使用index记录i
            }
        }
        if (index == -1){//说明delId在数组中不存在，没找到
//            System.out.println("-----------没找到删除房屋信息编号-----------");
            return false;
        }
        //如果找到了
        for (int i = index; i < houseNum - 1; i++) {
            houses[i] = houses[i+1];
        }
        //把当前存在的房屋信息最后一个，设置null
        houses[--houseNum] = null;//houseNum-1就是数组最后一个元素
        //这里不能写houses.length-1,因为houses.length-1是整个数组的最后一个位置
        //而houseNum-1是数组中房屋信息个数的最后一个元素
        return true;
    }

    //find()方法，找到了就返回house对象，找不到返回null
    public house find(int findId){
        for (int i = 0; i < houseNum; i++) {
            if (findId == houses[i].getId()){ //如果findId == 查找房屋下标所对应的id
                return houses[i];
            }
        }
        return null;
    }

}
