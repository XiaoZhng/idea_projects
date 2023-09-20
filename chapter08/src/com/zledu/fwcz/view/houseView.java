package com.zledu.fwcz.view;

import com.zledu.fwcz.domain.house;
import com.zledu.fwcz.service.houseService;

import java.util.Scanner;

public class houseView {
    //属性
    private boolean loop = true;//控制主菜单
    private String key = "";//接收用户菜单选择
    Scanner scanner = new Scanner(System.in);
    private houseService houseService = new houseService(2);//设置数组的长度

    //1.编写houseAdd()，显示房屋添加显示
    public void houseAdd() {
        System.out.println("----------添加房屋----------");
        System.out.print("姓名：");
        String name = scanner.next();
        System.out.print("电话：");
        String phone = scanner.next();
        System.out.print("地址：");
        String address = scanner.next();
        System.out.print("月租：");
        int rent = scanner.nextInt();
        System.out.print("状态：");
        String state = scanner.next();
        //把接收用户添加的信息，存放在newHouse中
        house newHouse = new house(0, name, phone, address, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("----------添加房屋完成----------");
        }
    }

    //2.编写houseFind()，显示查找页面
    public void houseFind() {
        System.out.println("----------查找房屋信息----------");
        System.out.print("请输入查找房屋编号：");
        int findId = scanner.nextInt();
        house house = houseService.find(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("----------查找房屋信息不存在----------");
        }
    }

    //3.编写houseDel()，显示房屋删除显示
    public void houseDel() {
        System.out.println("----------删除房屋----------");
        System.out.print("请选择待删除房屋编号(-1退出)：");
        int delId = scanner.nextInt();
        if (delId == -1) {
            System.out.println("----------放弃删除房屋----------");
            return;
        }
        System.out.print("请确认是否删除(Y确认)，请小心选择：");
        String choice = scanner.next().toUpperCase();//判断输入大小写
        if (choice.equals("Y")) {
            if (houseService.del(delId)) {
                System.out.println("----------删除房屋完成----------");
            } else {
                System.out.println("----------房屋编号不存在----------");
            }
        } else {
            System.out.println("----------放弃删除房屋----------");
        }

    }

    //4.编写houseUpdate()，显示修改房屋信息
    public void houseUpdate() {
        System.out.println("----------修改房屋信息----------");
        System.out.print("请输入要修改的编号(-1退出)：");
        int update = scanner.nextInt();
        if (update == -1) {
            System.out.println("----------放弃修改房屋信息----------");
            return;
        }
        //直接调用houseService.find()，把update传入,看看是否能查找得到该编号对应的数组
        house house = houseService.find(update);
        //判断如果house返回null，就给出提示不存在
        if (house == null) {
            System.out.println("----------修改房屋信息编号不存在----------");
            return;
        }
        //存在的情况
        System.out.println("输入0则不修改");
        System.out.print("姓名(" + house.getName() + ")：");
        String name = scanner.next();//接收修改信息
        //判断如果没输入0(修改)，则用setter()修改
        if (!("0".equals(name))) {
            house.setName(name);
        }
        System.out.print("电话(" + house.getPhone() + ")：");
        String phone = scanner.next();//接收修改信息
        //判断如果没输入0(修改)，则用setter()修改
        if (!("0".equals(phone))) {
            house.setPhone(phone);
        }
        System.out.print("地址(" + house.getAddress() + ")：");
        String address = scanner.next();//接收修改信息
        //判断如果没输入0(修改)，则用setter()修改
        if (!("0".equals(address))) {
            house.setAddress(address);
        }
        System.out.print("月租(" + house.getRent() + ")：");
        int rent = scanner.nextInt();//接收修改信息
        //判断如果没输入0(修改)，则用setter()修改
        if (0 != rent) {
            house.setRent(rent);
        }
        System.out.print("状态(" + house.getState() + ")：");
        String state = scanner.next();//接收修改信息
        //判断如果没输入0(修改)，则用setter()修改
        if (!("0".equals(state))) {
            house.setState(state);
        }
        System.out.println("----------房屋信息修改成功----------");
    }

    //5.编写houseList()，显示房屋列表
    public void houseList() {
        System.out.println("----------房屋列表----------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        house[] house = houseService.list();
        //遍历list()返回的数组
        for (int i = 0; i < house.length; i++) {
            //判断如果返回的数组不是null则显示
            if (!(house[i] == null)) {
                System.out.println(house[i]);
            }
        }
        System.out.println("----------房屋列表完成----------");
    }

    //6.编写exit(),退出显示
    public void exit() {
        System.out.print("请确认是否退出(Y确认)，请小心选择：");
        String choice = scanner.next().toUpperCase();
        if (choice.equals("Y")) {
            loop = false;
        } else {
            System.out.println("你终止了退出---");
        }
    }

    //编写mainMenu(),显示主菜单
    public void mainMenu() {
        do {
            System.out.println("\n----------房屋出租系统----------");
            System.out.println("1.新增房源:");
            System.out.println("2.查找房屋:");
            System.out.println("3.删除房屋:");
            System.out.println("4.修改房屋信息:");
            System.out.println("5.放屋列表:");
            System.out.println("6.退出:");

            System.out.print("请选择(1-6):");
            //通过scanner接收用户输入
            key = scanner.next();

            switch (key) {
                case "1":
                    houseAdd();
                    break;
                case "2":
                    houseFind();
                    break;
                case "3":
                    houseDel();
                    break;
                case "4":
                    houseUpdate();
                    break;
                case "5":
                    houseList();
                    break;
                case "6":
                    exit();
                    break;
            }

        } while (loop);
    }
}
