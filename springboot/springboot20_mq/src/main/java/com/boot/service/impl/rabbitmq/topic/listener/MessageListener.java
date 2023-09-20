package com.boot.service.impl.rabbitmq.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Alonso
 */
//@Component
public class MessageListener {

    @RabbitListener(queues = "topic_queue")
    public void receive(String id){
        System.out.println("与完成短信发送业务(rabbit topic1) id= " + id);
    }

    @RabbitListener(queues = "topic_queue2")
    public void receive2(String id){
        System.out.println("与完成短信发送业务(rabbit topic2) id= " + id);
    }
}
