package com.pbattistella.order.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDomainRepository extends JpaRepository<OrderModel, String> {
}
