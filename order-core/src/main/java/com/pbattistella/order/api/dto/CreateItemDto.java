package com.pbattistella.order.api.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateItemDto {

    private Integer quantity;
    private Double pricePerUnit;
    private CreateProductDto product;

}
