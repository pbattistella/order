package com.pbattistella.query.read.order.model;

import com.pbattistella.query.read.customer.model.CustomerModelRead;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@DynamicUpdate
@Table(name = "order")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderModelRead {

    @Id
    private String id;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(nullable = false, length = 50)
    private String status;

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerModelRead customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ItemModelRead> items;
}
