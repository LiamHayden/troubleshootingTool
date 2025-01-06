-- Inserting sample data into the customer table
INSERT INTO customer (name, access_url) VALUES
('Office of Public Works', 'http://example.com/'),
('Department of Housing', 'http://example.com/doh');

-- Inserting sample data into the asset_tag table
INSERT INTO asset_tag (tag_number) VALUES
('91938'),
('91940'),
('91918');

-- Inserting sample data into the printer table
INSERT INTO printer (model, asset_tag_id) VALUES
('HP Color LaserJet Managed MFP E877', 1),
('HP Color LaserJet Enterprise MFP X58045dn', 2),
('HP Color LaserJet Managed MFP E87640', 3);

-- Associating customers with printers in the join table
INSERT INTO customer_printer (customer_id, printer_id) VALUES
(1, 1),  -- Office of Public Works with HP Color LaserJet Managed MFP E877
(1, 2),  -- Office of Public Works with HP Color LaserJet Enterprise MFP X58045dn
(2, 2);  -- Department of Housing with HP Color LaserJet Enterprise MFP X58045dn

-- Inserting sample data into the ticket table
INSERT INTO ticket (number, printer_id, customer_id) VALUES
('T12122024.357', 1, 1),
('T10042012.321', 2, 1),
('T21112012.101', 3, 2);

-- Inserting sample data into the error_code table
INSERT INTO error_code (code) VALUES
('13.B9.D4'),
('49.3c.07');

-- Associating error codes with printers in the join table
INSERT INTO error_code_printer (error_code_id, printer_id) VALUES
(1, 1),  
(1, 2),  
(2, 2);

-- Inserting sample data into the problem table
INSERT INTO problem (description) VALUES
('Scan to Email'),
('49.3c.07 Error Code');

-- Inserting sample data into the question table
INSERT INTO question (questionDescription) VALUES
('Are a solid green and flashing amber LED at the network connection?'),
('Can you browse or ping the printer?');