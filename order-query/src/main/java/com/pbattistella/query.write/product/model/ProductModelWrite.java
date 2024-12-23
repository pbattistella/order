package com.pbattistella.query.write.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Builder
@Getter
@DynamicUpdate
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class ProductModelWrite {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    private String description;

    private String category;
}
