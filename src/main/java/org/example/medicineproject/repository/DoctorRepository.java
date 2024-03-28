package org.example.medicineproject.repository;

import org.example.medicineproject.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    List<Doctor> findAllByFirstNameAndLastName(String firstName, String lastName);
}
