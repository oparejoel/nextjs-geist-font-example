package com.example.carregistry.repository.inmemory;

import com.example.carregistry.model.Owner;
import com.example.carregistry.repository.OwnerRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryOwnerRepository implements OwnerRepository {
    private final Map<String, Owner> idToOwner = new HashMap<>();
    private final Map<String, String> emailToId = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(1000);

    @Override
    public synchronized Owner save(Owner owner) {
        if (owner.getId() == null || owner.getId().isBlank()) {
            String id = String.valueOf(sequence.getAndIncrement());
            owner.setId(id);
        }
        if (owner.getEmail() != null) {
            String existingId = emailToId.get(owner.getEmail());
            if (existingId != null && !existingId.equals(owner.getId())) {
                throw new IllegalArgumentException("Email already in use by another owner");
            }
            emailToId.put(owner.getEmail(), owner.getId());
        }
        idToOwner.put(owner.getId(), owner);
        return owner;
    }

    @Override
    public Optional<Owner> findById(String id) {
        return Optional.ofNullable(idToOwner.get(id));
    }

    @Override
    public Optional<Owner> findByEmail(String email) {
        String id = emailToId.get(email);
        return id == null ? Optional.empty() : Optional.ofNullable(idToOwner.get(id));
    }

    @Override
    public List<Owner> findAll() {
        return new ArrayList<>(idToOwner.values());
    }
}