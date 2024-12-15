package com.pbattistella.order.api.dto;

import com.pbattistella.order.application.command.CreateCustomerCommand;
import com.pbattistella.order.application.command.CreateItemCommand;
import com.pbattistella.order.application.command.CreateOrderCommand;
import com.pbattistella.order.application.command.CreateProductCommand;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateOrderDto {

    private CreateCustomerDto customer;
    private Date orderDate;
    private String status;
    private List<CreateItemDto> items;
    private Double totalAmout;

    public static CreateOrderCommand toCommand(CreateOrderDto dto) {

        CreateCustomerCommand customer = CreateCustomerCommand.builder()
            .id(dto.getCustomer().getId())
            .name(dto.getCustomer().getName())
            .email(dto.getCustomer().getEmail())
            .build();

        List<CreateItemCommand> items = dto.getItems().stream()
            .map(
                item -> CreateItemCommand.builder()
                    .id(UUID.randomUUID().toString())
                    .quantity(item.getQuantity())
                    .pricePerUnit(item.getPricePerUnit())
                    .product(CreateProductCommand.builder()
                        .id(item.getProduct().getId())
                        .name(item.getProduct().getName())
                        .description(item.getProduct().getDescription())
                        .category(item.getProduct().getCategory())
                        .build())
                    .build()
            )
            .toList();

        double total = dto.getItems().stream()
            .mapToDouble(item -> item.getQuantity() * item.getPricePerUnit())
            .sum();

        var orderId = UUID.randomUUID().toString();

        return CreateOrderCommand.builder()
            .id(orderId)
            .orderDate(dto.getOrderDate())
            .customer(customer)
            .items(items)
            .status(dto.getStatus())
            .totalAmout(total)
            .build();
    }

}
