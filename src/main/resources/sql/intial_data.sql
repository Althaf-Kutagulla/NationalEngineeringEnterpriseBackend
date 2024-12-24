-- Create and Insert Records into 'motors' Table
INSERT INTO motors (name, model)
VALUES
    ('Crompton', 'CRX-100'),
    ('Texmo', 'TMX-200'),
    ('Kirloskar', 'KIR-300'),
    ('Havells', 'HV-400'),
    ('V-Guard', 'VG-500'),
    ('ABB Motors', 'ABB-600'),
    ('Siemens', 'SM-700'),
    ('Lubi', 'LB-800'),
    ('Bharat Bijlee', 'BB-900'),
    ('Jyoti', 'JY-1000');

-- Create and Insert Records into 'categories' Table
INSERT INTO categories (name)
VALUES
    ('Bearings'),
    ('Couplings'),
    ('Pulleys'),
    ('Belts'),
    ('Motors'),
    ('Capacitors'),
    ('Switchgear'),
    ('Control Panels'),
    ('Lubricants'),
    ('Cooling Fans');

-- Create and Insert Records into 'workers' Table
INSERT INTO workers (first_name, last_name, phone_number, alter_phone_number, town, village, address, joined_date, left_date, working_status)
VALUES
    ('Rajesh', 'Kumar', '9876543210', '8765432109', 'Bangalore', 'Kumbalgodu', '123 MG Road', '2024-01-15 10:00:00', NULL, 'WORKING'),
    ('Priya', 'Sharma', '8765432198', '7654321987', 'Chennai', 'Tambaram', '456 Anna Nagar', '2023-12-01 09:00:00', NULL, 'WORKING'),
    ('Amit', 'Patel', '7654321098', '6543210987', 'Ahmedabad', 'Bopal', '789 CG Road', '2023-11-20 10:00:00', '2024-05-30 17:00:00', 'NOT_WORKING'),
    ('Sneha', 'Reddy', '6543210987', '5432109876', 'Hyderabad', 'Shamirpet', '101 Jubilee Hills', '2024-02-05 10:30:00', NULL, 'WORKING'),
    ('Vikram', 'Singh', '5432109876', '4321098765', 'Jaipur', 'Amer', '202 Pink City Road', '2023-08-10 09:45:00', '2024-03-25 18:00:00', 'NOT_WORKING'),
    ('Anjali', 'Verma', '4321098765', '3210987654', 'Delhi', 'Dwarka', '303 Connaught Place', '2024-03-01 11:00:00', NULL, 'WORKING'),
    ('Rohit', 'Mehta', '3210987654', '2109876543', 'Mumbai', 'Andheri', '404 Marine Drive', '2023-10-15 08:30:00', '2024-06-20 19:00:00', 'NOT_WORKING'),
    ('Deepika', 'Gupta', '2109876543', '1098765432', 'Kolkata', 'Salt Lake', '505 Park Street', '2024-04-10 09:15:00', NULL, 'WORKING'),
    ('Karan', 'Joshi', '1098765432', '1987654321', 'Pune', 'Hinjewadi', '606 FC Road', '2023-11-01 10:45:00', NULL, 'WORKING'),
    ('Meera', 'Iyer', '1987654321', '9876543210', 'Coimbatore', 'Peelamedu', '707 Race Course Road', '2023-12-20 09:30:00', '2024-07-10 17:30:00', 'NOT_WORKING');

-- Create and Insert Records into 'customers' Table
INSERT INTO customers (first_name, last_name, phone_number, state, town, village)
VALUES
    ('Ramesh', 'Kumar', '9876543210', 'Karnataka', 'Bangalore', 'Jayanagar'),
    ('Priya', 'Sharma', '8765432198', 'Tamil Nadu', 'Chennai', 'Guindy'),
    ('Amit', 'Patel', '7654321098', 'Gujarat', 'Ahmedabad', 'Maninagar'),
    ('Sneha', 'Reddy', '6543210987', 'Telangana', 'Hyderabad', 'Secunderabad'),
    ('Vikram', 'Singh', '5432109876', 'Rajasthan', 'Jaipur', 'Malviya Nagar'),
    ('Anjali', 'Verma', '4321098765', 'Delhi', 'New Delhi', 'Saket'),
    ('Rohit', 'Mehta', '3210987654', 'Maharashtra', 'Mumbai', 'Borivali'),
    ('Deepika', 'Gupta', '2109876543', 'West Bengal', 'Kolkata', 'Salt Lake'),
    ('Karan', 'Joshi', '1098765432', 'Madhya Pradesh', 'Indore', 'Palasia'),
    ('Meera', 'Iyer', '1987654321', 'Kerala', 'Kochi', 'Fort Kochi');

-- Create and Insert Records into 'products' Table
INSERT INTO products (name, category_id, quantity, price)
VALUES
    ('SKF Bearing', 1, 50, 1200.00),           -- Bearings
    ('Fenner Coupling', 2, 30, 800.00),        -- Couplings
    ('SPZ Pulley', 3, 40, 500.00),             -- Pulleys
    ('V-Belt 123', 4, 70, 300.00),             -- Belts
    ('Induction Motor', 5, 10, 25000.00),      -- Motors
    ('Electrolytic Capacitor', 6, 100, 20.00), -- Capacitors
    ('MCB Switchgear', 7, 25, 1500.00),        -- Switchgear
    ('Control Panel', 8, 5, 45000.00),         -- Control Panels
    ('Synthetic Lubricant', 9, 60, 350.00),    -- Lubricants
    ('Cooling Fan 220V', 10, 15, 700.00);      -- Cooling Fans
