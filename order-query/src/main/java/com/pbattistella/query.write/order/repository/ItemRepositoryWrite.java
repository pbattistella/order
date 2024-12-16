package com.pbattistella.query.write.order.repository;

import com.pbattistella.query.write.order.model.ItemModelWrite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositoryWrite extends JpaRepository<ItemModelWrite, String> {
}
