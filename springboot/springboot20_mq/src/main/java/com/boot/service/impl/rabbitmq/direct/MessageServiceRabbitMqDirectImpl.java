package com.boot.service.impl.rabbitmq.direct;

import com.boot.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alonso
 */
//@Service
public class MessageServiceRabbitMqDirectImpl implements MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(Integer id) {
        System.out.println("待发送短信的订单已纳入处理队列（rabbitmq direct）：id= " + id);
        amqpTemplate.convertAndSend("directChange", "direct", id);
    }

    @Override
    public Integer doMessage() {
        return null;
    }
}
