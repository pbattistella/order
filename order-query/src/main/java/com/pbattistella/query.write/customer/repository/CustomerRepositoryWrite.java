package com.pbattistella.query.write.customer.repository;

import com.pbattistella.query.write.customer.model.CustomerModelWrite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositoryWrite extends JpaRepository<CustomerModelWrite, String> {
}
