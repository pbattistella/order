CREATE TABLE item (
    id  VARCHAR(36) NOT NULL,
    order_id VARCHAR(36) NOT NULL,
    quantity INTEGER NOT NULL,
    price_per_unit NUMERIC(10, 2) NOT NULL,
    product_id VARCHAR(36) NOT NULL,
    CONSTRAINT item_pk PRIMARY KEY (id),
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES "order"(id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product(id)
);