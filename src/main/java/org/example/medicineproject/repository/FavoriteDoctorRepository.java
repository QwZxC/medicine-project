package org.example.medicineproject.repository;

import org.example.medicineproject.entity.FavoriteDoctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FavoriteDoctorRepository extends JpaRepository<FavoriteDoctor, UUID> {

    void deleteByDoctorUuid(UUID doctorUuid);
}
