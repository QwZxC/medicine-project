package org.example.medicineproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.medicineproject.dto.DoctorDto;
import org.example.medicineproject.dto.HospitalDto;
import org.example.medicineproject.entity.Doctor;
import org.example.medicineproject.entity.FavoriteDoctor;
import org.example.medicineproject.entity.FavoriteHospital;
import org.example.medicineproject.entity.Hospital;
import org.example.medicineproject.excpetion.NotFoundException;
import org.example.medicineproject.repository.DoctorRepository;
import org.example.medicineproject.repository.FavoriteDoctorRepository;
import org.example.medicineproject.repository.FavoriteHospitalRepository;
import org.example.medicineproject.repository.HospitalRepository;
import org.example.medicineproject.service.api.FavoriteService;
import org.example.medicineproject.service.api.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final UserService userService;
    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;
    private final FavoriteDoctorRepository favoriteDoctorRepository;
    private final FavoriteHospitalRepository favoriteHospitalRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DoctorDto> getFavoriteDoctors() {
        List<Doctor> doctors = doctorRepository.findDoctorsByUserUuid(userService.getCurrentUser().getUuid());
        List<DoctorDto> dtos = new ArrayList<>(doctors.size());
        doctors.forEach(doctor -> dtos.add(modelMapper.map(doctor, DoctorDto.class)));
        return dtos;
    }

    @Override
    public List<HospitalDto> getFavoriteHospitals() {
        List<Hospital> hospitals = hospitalRepository.findHospitalsByUserUuid(userService.getCurrentUser().getUuid());
        List<HospitalDto> dtos = new ArrayList<>(hospitals.size());
        hospitals.forEach(hospital -> dtos.add(modelMapper.map(hospital, HospitalDto.class)));
        return dtos;
    }

    @Override
    public DoctorDto createFavoriteDoctor(UUID doctorUuid) {
        FavoriteDoctor fd = new FavoriteDoctor();
        fd.setUser(userService.getCurrentUser());
        Doctor doctor = doctorRepository.findById(doctorUuid).orElseThrow(() -> new NotFoundException("Не существующий доктор"));
        fd.setDoctor(doctor);
        favoriteDoctorRepository.save(fd);
        return modelMapper.map(doctor, DoctorDto.class);
    }

    @Override
    public HospitalDto createFavoriteHospital(UUID hospitalUuid) {
        FavoriteHospital fd = new FavoriteHospital();
        fd.setUser(userService.getCurrentUser());
        Hospital hospital = hospitalRepository.findById(hospitalUuid).orElseThrow(() -> new NotFoundException("Не существующая больница"));
        fd.setHospital(hospital);
        favoriteHospitalRepository.save(fd);
        return modelMapper.map(hospital, HospitalDto.class);
    }


}
