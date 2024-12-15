CREATE TABLE product (
    id  VARCHAR(36) NOT NULL,
    name VARCHAR NOT NULL,
    description VARCHAR,
    category VARCHAR,
    CONSTRAINT product_pk PRIMARY KEY (id)
);