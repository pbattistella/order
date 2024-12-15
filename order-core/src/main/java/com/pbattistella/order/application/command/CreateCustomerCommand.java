package com.pbattistella.order.application.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class CreateCustomerCommand {

    private String id;
    private String name;
    private String email;

}
