package com.pbattistella.query.write.order.model;

import com.pbattistella.query.write.customer.model.CustomerModelWrite;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@DynamicUpdate
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
public class OrderModelWrite {

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
    private CustomerModelWrite customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemModelWrite> items = new ArrayList<>();

}
