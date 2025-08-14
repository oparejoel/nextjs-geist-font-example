package com.example.carregistry.repository;

import com.example.carregistry.model.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {
    Owner save(Owner owner);
    Optional<Owner> findById(String id);
    Optional<Owner> findByEmail(String email);
    List<Owner> findAll();
}