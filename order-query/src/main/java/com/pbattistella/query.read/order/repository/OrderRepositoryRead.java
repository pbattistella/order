package com.pbattistella.query.read.order.repository;

import com.pbattistella.query.read.order.model.OrderModelRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrderRepositoryRead extends JpaRepository<OrderModelRead, String> {
}
