package com.zledu.mhl.service;

import com.zledu.mhl.dao.DiningTableDAO;
import com.zledu.mhl.domain.DiningTable;

import java.util.List;

/**
 * @author Alonso
 */
public class DiningTableService {

    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    //显示餐桌信息
    public List<DiningTable> list(){

        List<DiningTable> diningTables = diningTableDAO.QueryMultiply("select id, state from DiningTable", DiningTable.class);
        return diningTables;

    }

    //显示餐桌是否存在
    //传入餐桌编号判断
    public DiningTable TableState(int tabId){

        DiningTable table =
                diningTableDAO.QuerySingle("select * from DiningTable where id = ?", DiningTable.class, tabId);
        return table;
    }

    //修改餐桌状态
    public boolean updateTabState(int tabId, String orderName, String orderTel){

        int update =
                diningTableDAO.update("update DiningTable set state = '已预定', orderName=?, orderTel=? where id=?", orderName, orderTel, tabId);
        return update > 0;
    }

    //修改生成账单中餐桌的状态
    //传入餐桌编号和状态
    public Boolean updateDiningTableState(int diningTableId, String state){
        int update = diningTableDAO.update("update DiningTable set state = ? where id = ?", state, diningTableId);
        return update > 0;
    }

    //编写方法，结账成功后，把餐桌设为空闲
    public Boolean updateDiningTableByFree(int id){
        int update = diningTableDAO.update("update diningTable set state = '空', orderName = '', orderTel = '' where id = ?", id);
        return update > 0;
    }

}
