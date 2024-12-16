package com.pbattistella.query.write.product.repository;

import com.pbattistella.query.write.product.model.ProductModelWrite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryWrite extends JpaRepository<ProductModelWrite, String> {
}
