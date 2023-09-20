package com.spring.connection.service;


import com.spring.connection.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Alonso
 */
@Service

//propagation：事务的传播行为
//isolation：事务的隔离级别
//timeout：事务在一定时间内进行提交，默认-1，秒为单位
//readOnly：只读，默认为false，可以查询，也可以增加修改删除，设置为true时，只能读(查询操作)
//rollbackFor：程序出现哪些异常需要回滚，值为异常的class写法
//noRollbackFor：程序出现哪些异常不需要回滚，值为异常的class写法
//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
@Transactional
public class UserService {

    //注入dao
    @Autowired
    private UserDAO userDAO;

    public void accountMoney(){

            //第一步 开启事务

            //第二步 进行业务操作
            userDAO.addMoney();

            //模拟异常
            int i = 10/0;

            userDAO.reduceMoney();

            //第三步 没有发生异常，提交事务

            //第四步 出现异常，事务回滚
    }
}
