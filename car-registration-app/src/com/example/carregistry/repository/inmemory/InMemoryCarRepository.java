package com.example.carregistry.repository.inmemory;

import com.example.carregistry.model.Car;
import com.example.carregistry.repository.CarRepository;

import java.util.*;

public class InMemoryCarRepository implements CarRepository {
    private final Map<String, Car> vinToCar = new HashMap<>();
    private final Map<String, String> plateToVin = new HashMap<>();

    @Override
    public synchronized Car save(Car car) {
        if (plateToVin.containsKey(car.getPlateNumber())) {
            String existingVin = plateToVin.get(car.getPlateNumber());
            if (!existingVin.equals(car.getVin())) {
                throw new IllegalArgumentException("Plate number already in use by another car");
            }
        }
        vinToCar.put(car.getVin(), car);
        plateToVin.put(car.getPlateNumber(), car.getVin());
        return car;
    }

    @Override
    public Optional<Car> findByVin(String vin) {
        return Optional.ofNullable(vinToCar.get(vin));
    }

    @Override
    public Optional<Car> findByPlate(String plateNumber) {
        String vin = plateToVin.get(plateNumber);
        return vin == null ? Optional.empty() : Optional.ofNullable(vinToCar.get(vin));
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(vinToCar.values());
    }
}