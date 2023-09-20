package com.zledu.mhl.service;

import com.zledu.mhl.dao.BillDAO;
import com.zledu.mhl.dao.MenuDAO;
import com.zledu.mhl.dao.MultiTableDAO;
import com.zledu.mhl.domain.Bill;
import com.zledu.mhl.domain.MultiTable;

import java.util.List;
import java.util.UUID;

/**
 * @author Alonso
 * 账单的服务层
 */
public class BillService {

    //需要 BillDAO属性
    private BillDAO billDAO = new BillDAO();
    //生成菜单方法需要传入菜单的信息
    private MenuService menuService = new MenuService();
    //修改餐桌状态需要 DiningTableService属性
    private DiningTableService diningTableService = new DiningTableService();
    //多表查询，增加 MultiTableDAO 属性
    private MultiTableDAO multiTableDAO = new MultiTableDAO();

    //生成账单
    //一道菜对应一行账单
    //账单id 账单编号 菜品编号 菜品数量 菜品价格 餐桌编号 账单日期 支付状态
    public Boolean Bill(int menuId, int num, int diningTableId){

        //生成账单编号(UUID)
        String billId = UUID.randomUUID().toString();

        int update = billDAO.update("insert into bill values(null, ?, ?, ?, ?, ?, now(), '未结账')",
                billId, menuId, num, menuService.getMenuById(menuId).getPrice() * num, diningTableId);

        //update <= 0 添加失败
        if (update <= 0){
            return false;
        }

        //修改餐桌状态
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");

    }

    //查看账单
    public List<Bill> list(){
        return billDAO.QueryMultiply("select * from bill", Bill.class);
    }

    //查看账单(多表)
    public List<MultiTable> MultiTableList(){
        return multiTableDAO.QueryMultiply("SELECT bill.*, menu.name FROM bill, menu where bill.menuId = menu.id", MultiTable.class);
    }

    //根据餐桌号 判断结账的餐桌状态是否为未结账
    public Boolean CheckOut(int diningTableId){
        Bill bill = billDAO.QuerySingle("select * from bill where diningTableId = ? and payState = '未结账'", Bill.class, diningTableId);
        //bill != null表示有
        return bill != null;
    }

    //修改bill表中的支付状态
    public Boolean CheckOutByPayState(String payState, int diningTableId){

        //如果这里要使用事务的话，需要用 ThreadLocal来解决，框架中比如mybatis 提供了事务支持

        //1.修改bill表
        //修改payState状态
        int update = billDAO.update("update bill set payState = ? where diningTableId = ?", payState, diningTableId);
        if (update <= 0){ //update <= 0 表示修改失败
            return false;
        }

        //2.修改diningTable表
        //关于修改diningTable表的业务，在diningTableService中完成，各司其职
        if (!(diningTableService.updateDiningTableByFree(diningTableId))){
            return false;
        }

        return true;
    }

}
