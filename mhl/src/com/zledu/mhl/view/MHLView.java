package com.zledu.mhl.view;

import com.zledu.mhl.domain.*;
import com.zledu.mhl.service.*;
import com.zledu.mhl.utils.Utility;

import java.util.List;

/**
 * @author Alonso
 */
public class MHLView {
    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

    private boolean loop = true;//控制主菜单循环
    private String key;//记录用户的输入
    //因为要调用 业务层中的方法，所以要创建对应的 业务层对象
    private EmployeeService employeeService = new EmployeeService();
    private DiningTableService diningTableService = new DiningTableService();
    private MenuService menuService = new MenuService();
    private BillService billService = new BillService();
    private UserService userService = new UserService();

    //扩展功能，显示餐厅成员
    public void Users(){
        System.out.println("========餐厅成员========");
        System.out.println("id\t\t姓名\t\t\t\t职位");
        List<User> users = userService.UserList();
        for (User user : users) {
            System.out.println(user);
        }
    }

    //结账
    public void checkOut(){
        System.out.println("========结账服务========");
        System.out.print("请选择要结账的餐桌编号(-1退出)：");
        int diningTableId = Utility.readInt();
        if (diningTableId == -1){
            System.out.println("========取消结账========");
            return;
        }
        //判断餐桌号是否存在
        DiningTable table = diningTableService.TableState(diningTableId);
        if (table == null){
            System.out.println("========餐桌号不存在========");
            return;       }
        //验证餐桌是否需要结账
        if (!(billService.CheckOut(diningTableId))){
            System.out.println("========该餐桌不需要结账========");
            return;
        }
        System.out.print("结账的方式(现金/支付宝/微信/刷卡) 回车表示退出：");
        String payMode = Utility.readString(20, "");//如果回车 就是返回 ""
        if (payMode.equals("")){
            System.out.println("========退出结账========");
            return;
        }
        //再次确认结账
        //System.out.println("确认是否结账");
        char key = Utility.readConfirmSelection();
        if (key == 'Y'){
            //确认结账
            if (!(billService.CheckOutByPayState(payMode, diningTableId))){
                System.out.println("========结账失败========");
            }

            System.out.println("========结账完成========");
        }else {
            System.out.println("========结账失败========");
        }
    }

    //查看账单
    public void BillList(){
        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t\t桌号\t\t\t日期\t\t\t\t\t\t\t状态");
        List<Bill> list = billService.list();
        for (Bill bill : list) {
            System.out.println(bill);
        }
        System.out.println("========显示完毕========");

    }

    //查看账单(多表查询)
    public void MultiTableByBillList(){
        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t\t桌号\t\t\t日期\t\t\t\t\t\t\t状态\t\t\t菜品名");
        List<MultiTable> multiTables = billService.MultiTableList();
        for (MultiTable multiTable : multiTables) {
            System.out.println(multiTable);
        }
        System.out.println("========显示完毕========");
    }

    //点餐服务
    public void orderMenu(){
        System.out.println("========点餐服务========");
        System.out.print("请选择点餐的桌号(-1退出)：");
        int orderDiningTableId = Utility.readInt();
        if (orderDiningTableId == -1){
            System.out.println("========退出点餐========");
            return;
        }
        DiningTable table = diningTableService.TableState(orderDiningTableId);
        if (table == null){
            System.out.println("========餐桌号不存在========");
            return;
        }

        System.out.print("请选择菜品的编号(-1退出)：");
        int orderMenuId = Utility.readInt();
        if (orderMenuId == -1){
            System.out.println("========退出点餐========");
            return;
        }
        Menu menuById = menuService.getMenuById(orderMenuId);
        if (menuById == null){
            System.out.println("========菜品号不存在========");
            return;
        }

        System.out.print("请选择菜品的数量(-1退出)：");
        int orderMenuNum = Utility.readInt();
        if (orderMenuNum == -1){
            System.out.println("========退出点餐========");
            return;
        }

        //可以点餐
        //Boolean bill = billService.Bill(orderMenuId, orderMenuNum, orderDiningTableId);
        if (billService.Bill(orderMenuId, orderMenuNum, orderDiningTableId)){
            System.out.println("========点餐成功========");
        }

    }

    //显示所有菜品
    public void MenuList(){
        List<Menu> list = menuService.list();
        System.out.println("菜品编号\t\t菜品名\t\t类别\t\t价格");
        for (Menu menulist : list) {
            System.out.println(menulist);
        }

    }

    //显示餐桌状态
    public void tableList(){
        System.out.println("餐桌编号\t\t" + "餐桌状态");
        List<DiningTable> list = diningTableService.list();
        //返回的集合需要遍历显示内容
        for (DiningTable table : list){
            System.out.println(table);
        }
        System.out.println("========显示完毕========");
    }

    //预定餐桌
    public void orderTable(){
        System.out.println("========预定餐桌========");
        System.out.print("请选择要预定餐桌编号(-1退出):");
        int tabID = Utility.readInt();
        if (tabID == -1){
            System.out.println("========退出预定========");
            return;
        }
        //readConfirmSelection()得到的是 Y或者N
        char key = Utility.readConfirmSelection();
        if (key == 'Y'){ //要预定
            DiningTable table = diningTableService.TableState(tabID);
            if (table == null){
                System.out.println("========餐桌号不存在========");
                return;
            }
            if (!(table.getState().equals("空"))){ //当前餐桌不是 空状态，不能预定
                System.out.println("========该餐桌已被预定========");
                return;
            }
            //这时是 空状态，可以预定
            System.out.print("预定人的名字:");
            String orderName = Utility.readString(50);
            System.out.print("预定人的电话:");
            String orderTel = Utility.readString(50);
            if (diningTableService.updateTabState(tabID, orderName, orderTel)){
                System.out.println("========预定成功========");
            }else {
                System.out.println("========预定失败========");
            }
        }else {
            System.out.println("========取消预定========");
        }
    }

    //显示主菜单
    public void mainMenu(){

        while (loop){
            System.out.println("========满汉楼========");
            System.out.println("1.登录满汉楼");
            System.out.println("2.退出满汉楼");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("请输入账号：");
                    String loginId = Utility.readString(50);
                    System.out.print("请输入密码：");
                    String pwd = Utility.readString(50);
                    Employee employee = employeeService.getEmployee(loginId, pwd);
                    if (employee != null) { //说明用户存在
                        System.out.println("========【"+employee.getName()+"】登录成功========\n");
                        while (loop) {
                            System.out.println("========满汉楼二级菜单========");
                            System.out.println("1.显示餐桌状态");
                            System.out.println("2.预定餐桌");
                            System.out.println("3.显示所有菜品");
                            System.out.println("4.点餐服务");
                            System.out.println("5.查看账单");
                            System.out.println("6.结账");
                            System.out.println("7.餐厅成员");
                            System.out.println("9.退出满汉楼");
                            System.out.print("请输入你选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    tableList();
                                    //System.out.println("显示餐桌状态");
                                    break;
                                case "2":
                                    orderTable();
                                    //System.out.println("预定餐桌");
                                    break;
                                case "3":
                                    MenuList();
                                    //System.out.println("显示所有菜品");
                                    break;
                                case "4":
                                    orderMenu();
                                    //System.out.println("点餐服务");
                                    break;
                                case "5":
                                    //BillList();
                                    MultiTableByBillList();//多表查询
                                    //System.out.println("查看账单");
                                    break;
                                case "6":
                                    checkOut();
                                    //System.out.println("结账");
                                    break;
                                case "7":
                                    Users();
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                                default:
                                    System.out.print("输入错误，请重新上输出...\n");
                            }
                        }
                    }else {
                        System.out.println("========登录失败========");
                    }
                    break;
                case "2":
                     loop = false;
            }
        }
        System.out.println("退出满汉楼系统...");
    }
}
