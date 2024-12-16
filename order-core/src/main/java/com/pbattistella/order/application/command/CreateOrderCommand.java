package com.pbattistella.order.application.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class CreateOrderCommand {

    private String id;
    private CreateCustomerCommand customer;
    private Date orderDate;
    private String status;
    private List<CreateItemCommand> items;
    private Double totalAmount;

}
