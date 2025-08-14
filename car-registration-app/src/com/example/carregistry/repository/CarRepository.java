package com.example.carregistry.repository;

import com.example.carregistry.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    Car save(Car car);
    Optional<Car> findByVin(String vin);
    Optional<Car> findByPlate(String plateNumber);
    List<Car> findAll();
}