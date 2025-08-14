package com.example.carregistry.repository.inmemory;

import com.example.carregistry.model.Registration;
import com.example.carregistry.repository.RegistrationRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryRegistrationRepository implements RegistrationRepository {
    private final Map<String, Registration> idToRegistration = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(5000);

    @Override
    public synchronized Registration save(Registration registration) {
        idToRegistration.put(registration.getId(), registration);
        return registration;
    }

    public synchronized String nextId() {
        return String.valueOf(sequence.getAndIncrement());
    }

    @Override
    public Optional<Registration> findById(String id) {
        return Optional.ofNullable(idToRegistration.get(id));
    }

    @Override
    public List<Registration> findAll() {
        return new ArrayList<>(idToRegistration.values());
    }
}