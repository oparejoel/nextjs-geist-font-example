package com.carregistration.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:sqlite:car_registration.db";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL);
            initializeDatabase();
        }
        return connection;
    }

    private static void initializeDatabase() {
        try (Statement statement = connection.createStatement()) {
            // Create cars table
            String createCarsTable = """
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
                )
            """;
            statement.execute(createCarsTable);

            // Create registrations table
            String createRegistrationsTable = """
                CREATE TABLE IF NOT EXISTS registrations (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    car_id INTEGER NOT NULL,
                    registration_date DATE NOT NULL,
                    expiry_date DATE NOT NULL,
                    status TEXT DEFAULT 'ACTIVE',
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    FOREIGN KEY (car_id) REFERENCES cars(id) ON DELETE CASCADE
                )
            """;
            statement.execute(createRegistrationsTable);

            // Create indexes for better performance
            statement.execute("CREATE INDEX IF NOT EXISTS idx_license_plate ON cars(license_plate)");
            statement.execute("CREATE INDEX IF NOT EXISTS idx_vin ON cars(vin)");
            statement.execute("CREATE INDEX IF NOT EXISTS idx_owner_name ON cars(owner_name)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
