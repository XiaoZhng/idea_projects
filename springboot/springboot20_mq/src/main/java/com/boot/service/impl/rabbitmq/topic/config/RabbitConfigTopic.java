package com.boot.service.impl.rabbitmq.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alonso
 */
//@Configuration
public class RabbitConfigTopic {

    /**
     * durable：是否持久化，默认false
     * exclusive：是否当前连接专用，默认false
     * autoDelete：是否自动删除，当生产者或消费者不再使用此队列，自动删除
     */
    @Bean
    public Queue topicQueue(){
        return new Queue("topic_queue", true, true, true);
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue("topic_queue2");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicChange");
    }

    @Bean
    public Binding bindingTopic(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.*.id");
    }

    @Bean
    public Binding bindingTopic2(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.#");
    }
}
