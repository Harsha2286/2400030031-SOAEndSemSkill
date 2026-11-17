-- ============================================
-- Tourism Analytics Dashboard - Database Setup
-- Run this script in pgAdmin or psql
-- ============================================

-- Step 1: Create the database (run as superuser)
CREATE DATABASE tourism_db;

-- Step 2: Connect to tourism_db, then run below:

-- Step 3: Create tourists table
CREATE TABLE IF NOT EXISTS tourists (
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    country     VARCHAR(100) NOT NULL,
    email       VARCHAR(150),
    phone       VARCHAR(20),
    destination VARCHAR(100),
    visit_date  VARCHAR(20)
);

-- Step 4: Insert sample data
INSERT INTO tourists (name, country, email, phone, destination, visit_date) VALUES
('Alice Johnson',  'USA',         'alice@example.com',   '9876543210', 'Paris',     '2024-06-15'),
('Ravi Kumar',     'India',       'ravi@example.com',    '9123456789', 'Dubai',     '2024-07-20'),
('Maria Garcia',   'Spain',       'maria@example.com',   '9000112233', 'New York',  '2024-08-05'),
('Liu Wei',        'China',       'liu@example.com',     '9111222333', 'London',    '2024-09-10'),
('James Brown',    'UK',          'james@example.com',   '9222333444', 'Tokyo',     '2024-10-01'),
('Fatima Al-Said', 'UAE',         'fatima@example.com',  '9333444555', 'Singapore', '2024-11-18'),
('Haruto Tanaka',  'Japan',       'haruto@example.com',  '9444555666', 'Sydney',    '2024-12-25');
