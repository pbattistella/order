package com.pbattistella.config.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class Publisher {

    @Value("${queue.exchange}")
    private String exchange;

    @Value("${queue.routing}")
    private String routing;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void dispatch(String message) {
        rabbitTemplate.convertAndSend(exchange, routing, message);
    }
}
