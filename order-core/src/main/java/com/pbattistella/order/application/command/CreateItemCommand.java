package com.pbattistella.order.application.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class CreateItemCommand {

    private String id;
    private Integer quantity;
    private Double pricePerUnit;
    private CreateProductCommand product;

}
