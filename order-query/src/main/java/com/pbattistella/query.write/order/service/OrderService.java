package com.pbattistella.query.write.order.service;

import com.pbattistella.query.write.customer.repository.CustomerRepositoryWrite;
import com.pbattistella.query.write.order.amqp.event.OrderCreateEvent;
import com.pbattistella.query.write.customer.model.CustomerModelWrite;
import com.pbattistella.query.write.order.model.ItemModelWrite;
import com.pbattistella.query.write.order.model.OrderModelWrite;
import com.pbattistella.query.write.order.repository.ItemRepositoryWrite;
import com.pbattistella.query.write.order.repository.OrderRepositoryWrite;
import com.pbattistella.query.write.product.model.ProductModelWrite;
import com.pbattistella.query.write.product.repository.ProductRepositoryWrite;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {

    private static final String STATUS = "Processado";

    @Autowired
    private OrderRepositoryWrite orderRepositoryWrite;

    @Autowired
    private CustomerRepositoryWrite customerRepositoryWrite;

    @Autowired
    private ProductRepositoryWrite productRepositoryWrite;

    @Autowired
    private ItemRepositoryWrite itemRepositoryWrite;

    public void on(OrderCreateEvent orderEvent) {

        CustomerModelWrite customerModelWrite = CustomerModelWrite.builder()
            .id(orderEvent.getCustomer().getId())
            .name(orderEvent.getCustomer().getName())
            .email(orderEvent.getCustomer().getEmail())
            .build();

        customerRepositoryWrite.save(customerModelWrite);

        List<ProductModelWrite> productModelWriteList = orderEvent.getItems()
            .stream()
            .map(item -> ProductModelWrite.builder()
                .id(item.getProduct().getId())
                .name(item.getProduct().getName())
                .description(item.getProduct().getDescription())
                .category(item.getProduct().getCategory())
                .build()
            ).toList();

        productRepositoryWrite.saveAll(productModelWriteList);

        OrderModelWrite orderModelWrite = OrderModelWrite.builder()
            .id(orderEvent.getId())
            .orderDate(orderEvent.getOrderDate())
            .totalAmount(orderEvent.getTotalAmount())
            .status(STATUS)
            .customer(customerModelWrite)
            .build();

        orderRepositoryWrite.save(orderModelWrite);

        List<ItemModelWrite> itemModelWriteList = orderEvent.getItems()
            .stream()
            .map(item -> ItemModelWrite.builder()
                .id(item.getId())
                .order(orderModelWrite)
                .quantity(item.getQuantity())
                .pricePerUnit(item.getPricePerUnit())
                .product(ProductModelWrite.builder()
                    .id(item.getProduct().getId())
                    .name(item.getProduct().getName())
                    .description(item.getProduct().getDescription())
                    .category(item.getProduct().getCategory())
                    .build())
                .build()
            ).toList();

        itemRepositoryWrite.saveAll(itemModelWriteList);
    }
}
