package com.pbattistella.query.write.order.amqp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbattistella.query.write.order.amqp.event.OrderCreateEvent;
import com.pbattistella.query.write.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderSubscriber {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${queue.name}")
    public void createOrder(String message) {

        try {
            OrderCreateEvent orderEvent = objectMapper.readValue(message, OrderCreateEvent.class);

            orderService.on(orderEvent);

            System.out.println("Mensagem recebida com sucesso: " + orderEvent);
        } catch (Exception e) {
            System.err.println("Erro ao processar a mensagem: " + e.getMessage());
        }

    }

}
