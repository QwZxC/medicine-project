package org.example.medicineproject.repository;

import org.example.medicineproject.entity.FavoriteHospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FavoriteHospitalRepository extends JpaRepository<FavoriteHospital, UUID> {

    void deleteByHospitalUuid(UUID hospitalUuid);
}
