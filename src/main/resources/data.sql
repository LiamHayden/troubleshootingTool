-- Inserting sample data into the customer table
INSERT INTO customer (name, access_url) VALUES
('John Doe', 'http://example.com/john'),
('Jane Smith', 'http://example.com/jane');

-- Inserting sample data into the printer table
INSERT INTO printer (model, assettag) VALUES
('HP LaserJet 1010', 12345),
('Canon PIXMA 2000', 67890);

-- Associating customers with printers in the join table
INSERT INTO customer_printer (customer_id, printer_id) VALUES
(1, 1),  -- John Doe with HP LaserJet 1010
(1, 2),  -- John Doe with Canon PIXMA 2000
(2, 2);  -- Jane Smith with Canon PIXMA 2000