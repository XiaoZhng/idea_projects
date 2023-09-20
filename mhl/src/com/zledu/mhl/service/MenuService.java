package com.zledu.mhl.service;

import com.zledu.mhl.dao.MenuDAO;
import com.zledu.mhl.domain.Menu;

import java.util.List;


/**
 * @author Alonso
 * 显示菜单的业务层
 */
public class MenuService {

    private MenuDAO menuDAO = new MenuDAO();

    //显示菜品菜单
    public List<Menu> list(){
        return menuDAO.QueryMultiply("select * from menu", Menu.class);
    }

    //根据菜品编号得到菜品对象
    public Menu getMenuById(int menuId){
        return menuDAO.QuerySingle("select * from menu where id = ?", Menu.class, menuId);
    }
}
