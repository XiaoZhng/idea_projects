package com.mbplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbplus.mapper.ProductMapper;
import com.mbplus.mapper.UserMapper;
import com.mbplus.pojo.Product;
import com.mbplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Alonso
 */
@SpringBootTest
public class PlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testPage(){
        //current:当前显示的页面
        //size:每页显示的条数
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM db_user
        // WHERE is_deleted=0 LIMIT ?,?
        Page<User> userPage = new Page<User>(2, 3);
        userMapper.selectPage(userPage, null);
        System.out.println("当前页的总记录数= " + userPage.getRecords());
        System.out.println("总页数= " + userPage.getPages());
        System.out.println("总记录数= " + userPage.getTotal());
        System.out.println("当前页面= " + userPage.getCurrent());
        System.out.println("每页显示的条数= " + userPage.getSize());
    }

    //自定义分页功能
    @Test
    public void testPageVo(){
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPageVo(page, 20);
        System.out.println("当前页的总记录数= " + page.getRecords());
        System.out.println("总页数= " + page.getPages());
        System.out.println("总记录数= " + page.getTotal());
        System.out.println("当前页面= " + page.getCurrent());
        System.out.println("每页显示的条数= " + page.getSize());
    }

    @Test
    public void testProduct01(){
        //小李查询价格
        Product li = productMapper.selectById(1);
        System.out.println("小李查询价格= " + li.getPrice());
        //小王查询价格
        Product wang = productMapper.selectById(1);
        System.out.println("小王查询价格= " + wang.getPrice());

        //小李+50
        li.setPrice(li.getPrice() + 50);
        productMapper.updateById(li);
        //小王-30
        wang.setPrice(wang.getPrice() - 30);
        int result = productMapper.updateById(wang);
        if (result == 0){
            //操作失败，重新查询并修改
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice() - 30);
            productMapper.updateById(productNew);
        }

        //老板查询价格
        Product boss = productMapper.selectById(1);
        System.out.println("老板查询价格= " + boss.getPrice());
    }
}
