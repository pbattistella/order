package com.pbattistella.config.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {

    @Value("${queue.routing}")
    private String routing;

    @Value("${queue.exchange}")
    private String exchange;

    @Value("${queue.name}")
    private String queueName;

    @Bean
    public Queue testQueue() {
        return new Queue(queueName, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding testBinding(Queue testQueue, DirectExchange exchange) {
        return BindingBuilder
                .bind(testQueue)
                .to(exchange)
                .with(routing);
    }
}
