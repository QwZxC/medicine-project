package org.example.medicineproject.service.api;

import org.example.medicineproject.dto.DoctorDto;

import java.util.List;

public interface DoctorService {

    List<DoctorDto> getDoctorsByNameAndSurname(DoctorDto dto);
}
