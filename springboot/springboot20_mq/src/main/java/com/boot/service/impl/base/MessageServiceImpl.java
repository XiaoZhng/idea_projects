package com.boot.service.impl.base;

import com.boot.service.MessageService;

import java.util.ArrayList;

/**
 * @author Alonso
 */
//@Service
public class MessageServiceImpl implements MessageService {

    private ArrayList<Integer> list = new ArrayList<>();
    @Override
    public void sendMessage(Integer id) {
        System.out.println("待发送短信的订单已纳入处理队列：id= " + id);
        list.add(id);
    }

    @Override
    public Integer doMessage() {
        Integer id = list.remove(0);
        System.out.println("已完成短信发送业务：id= " + id);
        return id;
    }
}
