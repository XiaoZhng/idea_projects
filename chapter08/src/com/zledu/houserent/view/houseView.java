package com.zledu.houserent.view;

import com.zledu.houserent.domain.house;
import com.zledu.houserent.service.houseService;

import java.util.Scanner;

/**
 * 显示主页面
 * 接收用户的选择
 */
public class houseView {
    //定义变量
    private boolean loop = true; //控制显示菜单
    Scanner scanner = new Scanner(System.in);
    private String key = ""; // 接收用户输入的选择
    //只有创建一个新的houseService对象才能调用list()
    private houseService houseService = new houseService(2);//显示初始化,设置数组的大小为3
    boolean xz = true;//控制确认删除选择

    //1.编写addHouse(),接收输入,创建house对象,调用add方法
    public void addHouse() {
        System.out.println("-----------添加房屋-----------");
        System.out.print("姓名：");
        //新建各个变量接收用户输入的添加信息
        //这里不能用key,因为下面要把接收的信息全部传入house数组中,所以key满足不了
        String name = scanner.next();
        System.out.print("电话：");
        String phone = scanner.next();
        System.out.print("地址：");
        String address = scanner.next();
        System.out.print("月租：");
        int rent = scanner.nextInt();
        System.out.print("状态(未出租/已出租)：");
        String state = scanner.next();
        //创建house对象,调用add方法,id是系统分配的，用户不能输入
        house house = new house(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("-----------添加房屋信息成功-----------");
        } else {
            System.out.println("-----------添加房屋信息失败-----------");
        }
        System.out.println("-----------添加完成-----------");
    }

    //2.查找房屋信息，编写findHouse(),接收输入,调用find()方法
    //find()方法，找到了就返回house对象，找不到返回null
    public void findHouse() {
        System.out.println("-----------查找房屋信息-----------");
        System.out.print("请输入你要查找的id：");
        int findId = scanner.nextInt();
        house house = houseService.find(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("-----------查找的房屋信息id不存在-----------");
        }
    }

    //3.删除房屋信息，编写delHouse(),接收输入,调用del方法
    public void delHouse() {
        System.out.println("-----------删除房屋信息-----------");
        System.out.print("请选择待删除房屋编号(-1退出)：");
        int delId = scanner.nextInt();//创建delId接收用户输入删除房屋编号
        if (delId == -1) {
            return; //在方法中用return结束该方法
        }
        while (xz) {
            System.out.println("确认是否删除(Y/N),请小心选择：");
            String choice = scanner.next().toUpperCase();
            if (choice.equals("Y")) {
                if (houseService.del(delId)) {
                    System.out.println("-----------删除房屋信息成功-----------");
                } else {
                    System.out.println("---------删除房屋信息编号不存在---------");
                }
                break;
            } else if (choice.equals("N")) {
                System.out.println("-----------放弃删除房屋信息-----------");
                break;
            } else {
                xz = true;
            }
        }
    }

    //4.编写updateHouse(),显示修改房屋信息菜单
    public void updateHouse() {
        System.out.println("-----------修改房屋信息-----------");
        System.out.print("请选择待修改房屋编号(-1退出)：");
        int updataId = scanner.nextInt();
        System.out.println("(不修改请输入0)");
        if (updataId == -1){
            System.out.println("-----------放弃修改房屋信息-----------");
            return;
        }
        //根据输入的updateId查找对象
        //返回的是引用类型[即就是数组的元素]
        //因此后在后面对house.setXxxx(xxxx),就会修改houseService中数组的元素！(重点!)
        house house = houseService.find(updataId);
        if (house == null){
            System.out.println("---------修改房屋信息不存在---------");
            return;
        }
        System.out.print("姓名(" + house.getName() + ")：");
        String name = scanner.next();
        //这里这样理解：如果"0"是name时则不修改，前面加个!，意思相反如果"0"不是name时则修改
        if (!"0".equals(name)){
            house.setName(name);
        }

        System.out.print("电话("+house.getPhone()+"):");
        String phone = scanner.next();
        if (!"0".equals(phone)){
            house.setPhone(phone);
        }

        System.out.print("地址("+house.getAddress()+"):");
        String address = scanner.next();
        if(!"0".equals(address)){
            house.setAddress(address);
        }

        System.out.print("租金("+house.getRent()+"):");
        int rent = scanner.nextInt();
        if(rent != 0){
            house.setRent(rent);
        }

        System.out.print("状态("+house.getState()+"):");
        String state = scanner.next();
        if(!"0".equals(state)){
            house.setState(state);
        }
        System.out.println("---------修改房屋信息成功---------");
    }

    //5.编写listHouses(),显示房屋列表
    public void listHouses() {
        System.out.println("-----------房屋列表-----------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(已出租/未出租)");
        house[] houses = houseService.list();//得到所有房屋信息
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {//设置个判断,如果为null,就不用再显示了
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("-----------房屋列表完成-----------");
    }

    //6.编写exit(),完成退出确认功能
    public void exit() {
        while (xz) {
            System.out.println("确认是否退出(Y/N)：");
            String choice = scanner.next().toUpperCase();
            if (choice.equals("Y")) {
                loop = false;
                break;
            } else if (choice.equals("N")) {
                break;
            } else {
                xz = true;
            }
        }

    }

    public void mainMenu() {
        do {
            System.out.println("\n-----------房屋出租系统菜单-----------");
            System.out.println("1.新增房源");
            System.out.println("2.查找房屋");
            System.out.println("3.删除房屋");
            System.out.println("4.修改房屋信息");
            System.out.println("5.房屋列表");
            System.out.println("6.退出");

            System.out.print("请选择(1-6)：");
            key = scanner.next();
            switch (key) {
                case "1":
                    addHouse();
                    break;
                case "2":
                    findHouse();
                    break;
                case "3":
                    delHouse();
                    break;
                case "4":
                    updateHouse();
                    break;
                case "5":
                    listHouses();
                    break;
                case "6":
                    exit();
                    break;
                default:
                    System.out.println("输入不正确，请重新输入!");
            }

        } while (loop);
    }
}
