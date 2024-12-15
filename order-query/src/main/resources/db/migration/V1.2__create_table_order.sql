CREATE TABLE "order" (
    id  VARCHAR(36) NOT NULL,
    customer_id  VARCHAR(36) NOT NULL,
    order_date TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    total_amount NUMERIC(10, 2) NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (id),
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer(id)
);