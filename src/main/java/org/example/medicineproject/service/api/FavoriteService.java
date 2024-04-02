package org.example.medicineproject.service.api;

import org.example.medicineproject.dto.DoctorDto;
import org.example.medicineproject.dto.HospitalDto;

import java.util.List;
import java.util.UUID;

public interface FavoriteService {

    List<DoctorDto> getFavoriteDoctors();
    List<HospitalDto> getFavoriteHospitals();

    DoctorDto createFavoriteDoctor(UUID doctorUuid);
    HospitalDto createFavoriteHospital(UUID hopitalUuid);
}
