CREATE TABLE customer (
    id  VARCHAR(36) NOT NULL,
    name VARCHAR NOT NULL,
    email VARCHAR UNIQUE NOT NULL,
    CONSTRAINT customer_pk PRIMARY KEY (id)
);