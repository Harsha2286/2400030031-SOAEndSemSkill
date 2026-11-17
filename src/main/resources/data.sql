-- This file runs automatically when Spring Boot starts
-- It inserts data only if the table is empty

INSERT INTO tourists (name, country, email, phone, destination, visit_date)
SELECT 'Alice Johnson', 'USA', 'alice@example.com', '9876543210', 'Paris', '2024-06-15'
WHERE NOT EXISTS (SELECT 1 FROM tourists WHERE email = 'alice@example.com');

INSERT INTO tourists (name, country, email, phone, destination, visit_date)
SELECT 'Ravi Kumar', 'India', 'ravi@example.com', '9123456789', 'Dubai', '2024-07-20'
WHERE NOT EXISTS (SELECT 1 FROM tourists WHERE email = 'ravi@example.com');

INSERT INTO tourists (name, country, email, phone, destination, visit_date)
SELECT 'Maria Garcia', 'Spain', 'maria@example.com', '9000112233', 'New York', '2024-08-05'
WHERE NOT EXISTS (SELECT 1 FROM tourists WHERE email = 'maria@example.com');

INSERT INTO tourists (name, country, email, phone, destination, visit_date)
SELECT 'Liu Wei', 'China', 'liu@example.com', '9111222333', 'London', '2024-09-10'
WHERE NOT EXISTS (SELECT 1 FROM tourists WHERE email = 'liu@example.com');

INSERT INTO tourists (name, country, email, phone, destination, visit_date)
SELECT 'James Brown', 'UK', 'james@example.com', '9222333444', 'Tokyo', '2024-10-01'
WHERE NOT EXISTS (SELECT 1 FROM tourists WHERE email = 'james@example.com');
