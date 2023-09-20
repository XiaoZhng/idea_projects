package com.boot.service.impl.activemq;

import com.boot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Alonso
 */
//@Service
public class MessageServiceActiveImpl implements MessageService {

    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    //destinationName: "order.ssm.queue.id" 保存位置
    @Override
    public void sendMessage(Integer id) {
        System.out.println("待发送短信的订单已纳入处理队列：id= " + id);
        messagingTemplate.convertAndSend("order.ssm.queue.id", id);
    }

    @Override
    public Integer doMessage() {
        return messagingTemplate.receiveAndConvert("order.ssm.queue.id", Integer.class);
    }
}
