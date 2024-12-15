package com.pbattistella.queryread.order.repository;

import com.pbattistella.queryread.order.model.OrderModelRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrderRepositoryRead extends JpaRepository<OrderModelRead, String> {
}
