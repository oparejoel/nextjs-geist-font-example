package com.carregistration.dao;

import com.carregistration.model.Car;
import com.carregistration.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    
    public boolean insertCar(Car car) {
        String sql = """
            INSERT INTO cars (make, model, year, license_plate, owner_name, 
                            registration_date, color, vin, owner_phone, owner_email, owner_address)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, car.getMake());
            pstmt.setString(2, car.getModel());
            pstmt.setInt(3, car.getYear());
            pstmt.setString(4, car.getLicensePlate());
            pstmt.setString(5, car.getOwnerName());
            pstmt.setDate(6, Date.valueOf(car.getRegistrationDate()));
            pstmt.setString(7, car.getColor());
            pstmt.setString(8, car.getVin());
            pstmt.setString(9, car.getOwnerPhone());
            pstmt.setString(10, car.getOwnerEmail());
            pstmt.setString(11, car.getOwnerAddress());
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        car.setId(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars ORDER BY created_at DESC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                cars.add(mapResultSetToCar(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
    
    public Car getCarById(int id) {
        String sql = "SELECT * FROM cars WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToCar(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean updateCar(Car car) {
        String sql = """
            UPDATE cars SET make = ?, model = ?, year = ?, license_plate = ?, 
                           owner_name = ?, registration_date = ?, color = ?, vin = ?,
                           owner_phone = ?, owner_email = ?, owner_address = ?, 
                           updated_at = CURRENT_TIMESTAMP
            WHERE id = ?
        """;
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, car.getMake());
            pstmt.setString(2, car.getModel());
            pstmt.setInt(3, car.getYear());
            pstmt.setString(4, car.getLicensePlate());
            pstmt.setString(5, car.getOwnerName());
            pstmt.setDate(6, Date.valueOf(car.getRegistrationDate()));
            pstmt.setString(7, car.getColor());
            pstmt.setString(8, car.getVin());
            pstmt.setString(9, car.getOwnerPhone());
            pstmt.setString(10, car.getOwnerEmail());
            pstmt.setString(11, car.getOwnerAddress());
            pstmt.setInt(12, car.getId());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteCar(int id) {
        String sql = "DELETE FROM cars WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Car> searchCars(String keyword) {
        List<Car> cars = new ArrayList<>();
        String sql = """
            SELECT * FROM cars 
            WHERE make LIKE ? OR model LIKE ? OR license_plate LIKE ? 
               OR owner_name LIKE ? OR vin LIKE ?
            ORDER BY created_at DESC
        """;
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            String searchPattern = "%" + keyword + "%";
            pstmt.setString(1, searchPattern);
            pstmt.setString(2, searchPattern);
            pstmt.setString(3, searchPattern);
            pstmt.setString(4, searchPattern);
            pstmt.setString(5, searchPattern);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    cars.add(mapResultSetToCar(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
    
    public boolean isLicensePlateExists(String licensePlate) {
        return isLicensePlateExists(licensePlate, -1);
    }
    
    public boolean isLicensePlateExists(String licensePlate, int excludeId) {
        String sql = "SELECT COUNT(*) FROM cars WHERE license_plate = ? AND id != ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, licensePlate);
            pstmt.setInt(2, excludeId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean isVinExists(String vin) {
        return isVinExists(vin, -1);
    }
    
    public boolean isVinExists(String vin, int excludeId) {
        String sql = "SELECT COUNT(*) FROM cars WHERE vin = ? AND id != ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, vin);
            pstmt.setInt(2, excludeId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    private Car mapResultSetToCar(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getInt("year"));
        car.setLicensePlate(rs.getString("license_plate"));
        car.setOwnerName(rs.getString("owner_name"));
        car.setRegistrationDate(rs.getDate("registration_date").toLocalDate());
        car.setColor(rs.getString("color"));
        car.setVin(rs.getString("vin"));
        car.setOwnerPhone(rs.getString("owner_phone"));
        car.setOwnerEmail(rs.getString("owner_email"));
        car.setOwnerAddress(rs.getString("owner_address"));
        return car;
    }
}
