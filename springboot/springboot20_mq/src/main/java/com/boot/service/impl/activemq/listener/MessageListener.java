package com.boot.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author Alonso
 */
//@Component
public class MessageListener {

    @JmsListener(destination = "order.ssm.queue.id")
    @SendTo(value = "order.other.queue.id")
    public void receive(String id){
        System.out.println("已完成短信发送业务：id= " + id);
    }
}
