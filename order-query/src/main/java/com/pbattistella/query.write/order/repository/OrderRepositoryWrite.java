package com.pbattistella.query.write.order.repository;

import com.pbattistella.query.read.order.exception.OrderNotFoundException;
import com.pbattistella.query.write.order.model.ItemModelWrite;
import com.pbattistella.query.write.order.model.OrderModelWrite;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepositoryWrite extends JpaRepository<OrderModelWrite, String> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    default OrderModelWrite findByIdOrThrowNotFound(String id) {
        return findById(id).orElseThrow(() -> new OrderNotFoundException("Pedido não encontrado."));
    }

}
