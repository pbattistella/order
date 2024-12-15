package com.pbattistella.order.application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbattistella.config.amqp.Publisher;
import com.pbattistella.domain.model.OrderDomainRepository;
import com.pbattistella.domain.model.OrderModel;
import com.pbattistella.order.application.command.CreateOrderCommand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OrderApplicationService {

    private final OrderDomainRepository orderDomainRepository;

    @Autowired
    private final Publisher publisher;

    @Autowired
    private ObjectMapper objectMapper;

    public String handle(CreateOrderCommand cmd) {

        var orderId = cmd.getId();
        var data = objectMapper.valueToTree(cmd).toString();

        OrderModel order = OrderModel.builder()
            .id(orderId)
            .data(data)
            .build();

        orderDomainRepository.save(order);

        publisher.send(data);

        return orderId;

    }
}
