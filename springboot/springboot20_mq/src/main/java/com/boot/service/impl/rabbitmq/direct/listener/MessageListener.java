package com.boot.service.impl.rabbitmq.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Alonso
 */
//@Component
public class MessageListener {

    @RabbitListener(queues = "direct_queue")
    public void receive(String id){
        System.out.println("与完成短信发送业务(rabbit direct) id= " + id);
    }
}
