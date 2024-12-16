package com.pbattistella.query.write.order.amqp.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Builder
public class OrderCreateEvent {

    private final String id;

    private final Date orderDate;

    private final String status;

    private final BigDecimal totalAmount;

    private final CustomerEvent customer;

    private final List<ItemEvent> items;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class CustomerEvent {

        private final String id;

        private final String name;

        private final String email;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ItemEvent {

        private final String id;

        private final Integer quantity;

        private final BigDecimal pricePerUnit;

        private final ProductEvent product;

    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ProductEvent {

        private final String id;

        private final String name;

        private final String description;

        private final String category;
    }

}
