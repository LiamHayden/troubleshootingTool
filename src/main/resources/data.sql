-- Inserting sample data into the customer table
INSERT INTO customer (name, access_url) VALUES
('Office of Public Works', 'http://example.com/'),
('Department of Housing', 'http://example.com/doh');

-- Inserting sample data into the printer table
INSERT INTO printer (model, assettag) VALUES
('HP Color LaserJet Managed MFP E877', 91945),
('HP Color LaserJet Enterprise MFP X58045dn', 67890);

-- Associating customers with printers in the join table
INSERT INTO customer_printer (customer_id, printer_id) VALUES
(1, 1),  -- John Doe with HP LaserJet 1010
(1, 2),  -- John Doe with Canon PIXMA 2000
(2, 2);  -- Jane Smith with Canon PIXMA 2000