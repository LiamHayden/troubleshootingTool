-- Creating Customer table
CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    access_url VARCHAR(255) NOT NULL
);

-- Creating Printer table
CREATE TABLE printer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(255) NOT NULL,
    assettag INT NOT NULL
);

-- Creating the join table for the many-to-many relationship
CREATE TABLE customer_printer (
    customer_id BIGINT,
    printer_id BIGINT,
    PRIMARY KEY (customer_id, printer_id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (printer_id) REFERENCES printer(id)
);