-- Creating Customer table
CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    access_url VARCHAR(255) NOT NULL
);

-- Creating Asset Tag table
CREATE TABLE asset_tag (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tag_number VARCHAR(255) NOT NULL
);

-- Creating Printer table
CREATE TABLE printer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(255) NOT NULL,
    asset_tag_id BIGINT NOT NULL,
    FOREIGN KEY (asset_tag_id) REFERENCES asset_tag(id)
);

-- Creating the join table for the many-to-many relationship
CREATE TABLE customer_printer (
    customer_id BIGINT,
    printer_id BIGINT,
    PRIMARY KEY (customer_id, printer_id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (printer_id) REFERENCES printer(id)
);

-- Creating Ticket table
CREATE TABLE ticket (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(255) NOT NULL,
    printer_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    FOREIGN KEY (printer_id) REFERENCES printer(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

-- Creating Error Code table
CREATE TABLE error_code (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(255) NOT NULL
);

-- Creating the join table for the many-to-many relationship
CREATE TABLE error_code_printer (
    error_code_id BIGINT,
    printer_id BIGINT,
    PRIMARY KEY (error_code_id, printer_id),
    FOREIGN KEY (error_code_id) REFERENCES error_code(id),
    FOREIGN KEY (printer_id) REFERENCES printer(id)
);

-- Creating Problem table
CREATE TABLE problem (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL
);

-- Creating Question Table
CREATE TABLE question (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    questionDescription VARCHAR(255) NOT NULL
);