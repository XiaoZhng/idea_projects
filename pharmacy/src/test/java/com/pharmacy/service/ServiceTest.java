package com.pharmacy.service;

import com.pharmacy.domain.Drugstock;
import com.pharmacy.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ServiceTest {

    @Resource
    private UserService userService;

    @Resource
    private DrugsService drugsService;

    @Resource
    private DrugstockService drugstockService;

    //添加
    @Test
    public void addTest(){
        //用户表
//        User user = new User();
//        user.setUserName("tom");
//        user.setUserPassword("123456");
//        user.setRealName("汤姆");
//        user.setDept("销售部");
//        user.setEnable("1");
//        boolean result = userService.save(user);
//        System.out.println(user.getId());
//        Assertions.assertTrue(result);

        //药品表
//        Drugs drugs = new Drugs();
//        drugs.setDrugsName("999感冒灵");
//        drugs.setFactory("南宁市");
//        drugs.setSpecifications("50g/包");
//        drugs.setCompany("南宁市");
//        drugs.setPrice("29.9");
//        boolean result = drugsService.save(drugs);
//        Assertions.assertTrue(result);

        //库存表
        Drugstock drugstock = new Drugstock();
        drugstock.setDrugsId(3);
        drugstock.setStock(10);
        boolean result = drugstockService.save(drugstock);
        Assertions.assertTrue(result);
    }

    //修改
    @Test
    public void updateTest(){
        User user = new User();
        user.setId(3);
        user.setUserName("lucy");
        user.setUserPassword("321");
        user.setRealName("露西");
        user.setDept("管理层");
        user.setEnable("0");
        boolean result = userService.updateById(user);
        Assertions.assertTrue(result);
    }

    //查询
    @Test
    public void selectTest(){
        List<User> list = userService.list(null);
        list.forEach(System.out::println);
    }

    //删除
    @Test
    public void deleteTest(){
        boolean result = userService.removeById(3);
        Assertions.assertTrue(result);
    }
}
