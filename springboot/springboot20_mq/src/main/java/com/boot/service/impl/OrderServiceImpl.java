package com.boot.service.impl;

import com.boot.service.MessageService;
import com.boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alonso
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MessageService messageService;

    @Override
    public void order(Integer id) {
        //一系列操作，包含各种服务调用，处理各种业务
        System.out.println("订单处理开始");
        //短信消息处理
        messageService.sendMessage(id);
        System.out.println("订单处理结束");
        System.out.println();
    }
}
