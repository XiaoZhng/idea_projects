package com.boot.service.impl.rabbitmq.direct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alonso
 */
//@Configuration
public class RabbitConfigDirect {

    /**
     * durable：是否持久化，默认false
     * exclusive：是否当前连接专用，默认false
     * autoDelete：是否自动删除，当生产者或消费者不再使用此队列，自动删除
     */
    @Bean
    public Queue directQueue(){
        return new Queue("direct_queue", true, true, true);
    }

    @Bean
    public Queue directQueue2(){
        return new Queue("direct_queue2");
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directChange");
    }

    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct");
    }

    @Bean
    public Binding bindingDirect2(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct2");
    }
}
