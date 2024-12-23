package com.pbattistella.query.write.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pbattistella.query.write.product.model.ProductModelWrite;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Entity
@Builder
@Getter
@DynamicUpdate
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
public class ItemModelWrite {

    @Id
    private String id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "price_per_unit", nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerUnit;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductModelWrite product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore
    private OrderModelWrite order;


}
