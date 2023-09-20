package com.boot.service.impl.rocketmq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author Alonso
 */
@Component
@RocketMQMessageListener(topic = "order_id", consumerGroup = "group_rocketmq")
public class MessageListener implements RocketMQListener<Integer> {
    @Override
    public void onMessage(Integer id) {
        System.out.println("已完成短信发送业务(rocketmq),id= " + id);
    }
}
