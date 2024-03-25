package org.example.medicineproject.service.api;

import org.example.medicineproject.dto.HospitalDto;
import org.example.medicineproject.entity.Hospital;

import java.util.List;
import java.util.UUID;

public interface HospitalService {

    List<HospitalDto> getHospitals();
    Hospital getHospitalById(UUID uuid);
    Hospital getHospitalByName(String name);
}
