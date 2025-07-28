-- Car Registration Database Schema
-- SQLite database schema for car registration management system

-- Create cars table
CREATE TABLE IF NOT EXISTS cars (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    make TEXT NOT NULL,
    model TEXT NOT NULL,
    year INTEGER NOT NULL,
    license_plate TEXT UNIQUE NOT NULL,
    owner_name TEXT NOT NULL,
    registration_date DATE NOT NULL,
    color TEXT,
    vin TEXT UNIQUE NOT NULL,
    owner_phone TEXT,
    owner_email TEXT,
    owner_address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create registrations table
CREATE TABLE IF NOT EXISTS registrations (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    car_id INTEGER NOT NULL,
    registration_date DATE NOT NULL,
    expiry_date DATE NOT NULL,
    status TEXT DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (car_id) REFERENCES cars(id) ON DELETE CASCADE
);

-- Create indexes for better performance
CREATE INDEX IF NOT EXISTS idx_license_plate ON cars(license_plate);
CREATE INDEX IF NOT EXISTS idx_vin ON cars(vin);
CREATE INDEX IF NOT EXISTS idx_owner_name ON cars(owner_name);
CREATE INDEX IF NOT EXISTS idx_registration_date ON cars(registration_date);
CREATE INDEX IF NOT EXISTS idx_car_id ON registrations(car_id);
