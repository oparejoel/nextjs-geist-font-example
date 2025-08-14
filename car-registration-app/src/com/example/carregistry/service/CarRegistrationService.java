package com.example.carregistry.service;

import com.example.carregistry.model.*;
import com.example.carregistry.repository.CarRepository;
import com.example.carregistry.repository.OwnerRepository;
import com.example.carregistry.repository.RegistrationRepository;
import com.example.carregistry.repository.inmemory.InMemoryRegistrationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CarRegistrationService {
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;
    private final RegistrationRepository registrationRepository;

    public CarRegistrationService(CarRepository carRepository,
                                  OwnerRepository ownerRepository,
                                  RegistrationRepository registrationRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
        this.registrationRepository = registrationRepository;
    }

    public Owner createOrGetOwner(String fullName, String email) {
        if (email != null) {
            Optional<Owner> existing = ownerRepository.findByEmail(email);
            if (existing.isPresent()) {
                return existing.get();
            }
        }
        Owner owner = new Owner(fullName, email);
        return ownerRepository.save(owner);
    }

    public Car registerCar(String vin, String plate, String make, String model, int year) {
        Optional<Car> existingByVin = carRepository.findByVin(vin);
        if (existingByVin.isPresent()) {
            return existingByVin.get();
        }
        Car car = new Car(vin, plate, make, model, year);
        return carRepository.save(car);
    }

    public Registration createRegistration(Car car, Owner owner, int validityYears) {
        LocalDate now = LocalDate.now();
        LocalDate expires = now.plusYears(Math.max(1, validityYears));
        String id = (registrationRepository instanceof InMemoryRegistrationRepository)
                ? ((InMemoryRegistrationRepository) registrationRepository).nextId()
                : car.getVin() + "-" + now.toString();
        Registration registration = new Registration(id, car, owner, now, expires, RegistrationStatus.ACTIVE);
        return registrationRepository.save(registration);
    }

    public List<Car> listCars() {
        return carRepository.findAll();
    }

    public List<Registration> listRegistrations() {
        return registrationRepository.findAll();
    }
}