package com.example.carregistry;

import com.example.carregistry.model.Car;
import com.example.carregistry.model.Owner;
import com.example.carregistry.model.Registration;
import com.example.carregistry.repository.inmemory.InMemoryCarRepository;
import com.example.carregistry.repository.inmemory.InMemoryOwnerRepository;
import com.example.carregistry.repository.inmemory.InMemoryRegistrationRepository;
import com.example.carregistry.service.CarRegistrationService;

public class Main {
    public static void main(String[] args) {
        InMemoryCarRepository carRepo = new InMemoryCarRepository();
        InMemoryOwnerRepository ownerRepo = new InMemoryOwnerRepository();
        InMemoryRegistrationRepository regRepo = new InMemoryRegistrationRepository();
        CarRegistrationService service = new CarRegistrationService(carRepo, ownerRepo, regRepo);

        Owner owner = service.createOrGetOwner("Jane Doe", "jane@example.com");
        Car car = service.registerCar("1HGBH41JXMN109186", "ABC-123", "Toyota", "Corolla", 2018);
        Registration registration = service.createRegistration(car, owner, 2);

        System.out.println("Created owner: " + owner);
        System.out.println("Registered car: " + car);
        System.out.println("New registration: " + registration);

        System.out.println("All cars: ");
        service.listCars().forEach(c -> System.out.println(" - " + c));

        System.out.println("All registrations: ");
        service.listRegistrations().forEach(r -> System.out.println(" - " + r));
    }
}