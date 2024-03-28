package org.example.medicineproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.medicineproject.dto.DoctorDto;
import org.example.medicineproject.entity.Doctor;
import org.example.medicineproject.repository.DoctorRepository;
import org.example.medicineproject.service.api.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper mapper;

    @Override
    public List<DoctorDto> getDoctorsByNameAndSurname(DoctorDto dto) {
        List<Doctor> doctors = doctorRepository.findAllByFirstNameAndLastName(dto.getFirstName(), dto.getLastName());
        List<DoctorDto> dtos = new ArrayList<>(doctors.size());
        doctors.forEach(doctor -> dtos.add(mapper.map(doctor, DoctorDto.class)));
        return dtos;
    }
}
