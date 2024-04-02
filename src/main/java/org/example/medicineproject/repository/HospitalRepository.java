package org.example.medicineproject.repository;

import org.example.medicineproject.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HospitalRepository extends JpaRepository<Hospital, UUID> {

    Optional<Hospital> findByName(String name);

    @Query(value = """
            SELECT h FROM Hospital h
            JOIN FavoriteHospital fh ON h.uuid = fh.hospital.uuid
            WHERE fh.user.uuid = :uuid
            """)
    List<Hospital> findHospitalsByUserUuid(UUID uuid);
}
