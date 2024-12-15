package com.pbattistella.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDomainRepository extends JpaRepository<OrderModel, String> {
}
