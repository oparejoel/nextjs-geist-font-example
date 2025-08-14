package com.example.carregistry.model;

import java.time.LocalDate;
import java.util.Objects;

public class Registration {
    private final String id;
    private final Car car;
    private final Owner owner;
    private final LocalDate registeredOn;
    private final LocalDate expiresOn;
    private final RegistrationStatus status;

    public Registration(String id, Car car, Owner owner, LocalDate registeredOn, LocalDate expiresOn, RegistrationStatus status) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id is required");
        }
        if (car == null) {
            throw new IllegalArgumentException("car is required");
        }
        if (owner == null) {
            throw new IllegalArgumentException("owner is required");
        }
        this.id = id;
        this.car = car;
        this.owner = owner;
        this.registeredOn = registeredOn != null ? registeredOn : LocalDate.now();
        this.expiresOn = expiresOn;
        this.status = status != null ? status : RegistrationStatus.ACTIVE;
    }

    public String getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public Owner getOwner() {
        return owner;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public LocalDate getExpiresOn() {
        return expiresOn;
    }

    public RegistrationStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id='" + id + '\'' +
                ", car=" + car +
                ", owner=" + owner +
                ", registeredOn=" + registeredOn +
                ", expiresOn=" + expiresOn +
                ", status=" + status +
                '}';
    }
}