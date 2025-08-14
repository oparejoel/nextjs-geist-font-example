package com.example.carregistry.model;

import java.util.Objects;

public class Car {
    private final String vin; // Vehicle Identification Number (unique)
    private final String plateNumber; // License plate (unique per car)
    private final String make;
    private final String model;
    private final int year;

    public Car(String vin, String plateNumber, String make, String model, int year) {
        if (vin == null || vin.isBlank()) {
            throw new IllegalArgumentException("vin is required");
        }
        if (plateNumber == null || plateNumber.isBlank()) {
            throw new IllegalArgumentException("plateNumber is required");
        }
        this.vin = vin;
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(vin, car.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}