CREATE TABLE IF NOT EXISTS customer (
    customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    accessUrl VARCHAR(255)
    );

    CREATE TABLE IF NOT EXISTS PRINTER (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT,
    model VARCHAR(255),
    assetTag BIGINT,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
    );


INSERT INTO customer (name, accessUrl) VALUES ('OPW', 'www.google.com');

INSERT INTO printer (customer_id, model, assetTag) VALUES (1, 'E87640', 91964);