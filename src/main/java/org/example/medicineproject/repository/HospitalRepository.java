package org.example.medicineproject.repository;

import org.example.medicineproject.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface HospitalRepository extends JpaRepository<Hospital, UUID> {

    Optional<Hospital> findByName(String name);
}
