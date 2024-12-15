package com.pbattistella.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "order")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrderModel {

    @Id
    private String id;

    private String data;

    @Builder
    public OrderModel(String id, String data) {
        this.id = id;
        this.data = data;
    }
}
