CREATE TABLE IF NOT EXISTS customer (
    customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    accessUrl BIGINT
    );

INSERT INTO customer (name, accessUrl) VALUES ('OPW', 91934);