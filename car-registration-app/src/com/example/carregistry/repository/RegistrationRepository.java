package com.example.carregistry.repository;

import com.example.carregistry.model.Registration;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepository {
    Registration save(Registration registration);
    Optional<Registration> findById(String id);
    List<Registration> findAll();
}