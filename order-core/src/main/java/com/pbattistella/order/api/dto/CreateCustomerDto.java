package com.pbattistella.order.api.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateCustomerDto {

    private String id;
    private String name;
    private String email;

}
