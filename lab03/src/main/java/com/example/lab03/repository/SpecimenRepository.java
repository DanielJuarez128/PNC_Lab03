package com.example.lab03.repository;

import com.example.lab03.entity.Specimen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpecimenRepository extends JpaRepository<Specimen, UUID> {
}
