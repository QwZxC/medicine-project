package org.example.medicineproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.medicineproject.dto.HospitalDto;
import org.example.medicineproject.entity.Hospital;
import org.example.medicineproject.entity.Review;
import org.example.medicineproject.excpetion.NotFoundException;
import org.example.medicineproject.repository.HospitalRepository;
import org.example.medicineproject.repository.ReviewRepository;
import org.example.medicineproject.service.api.HospitalService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;
    private final ModelMapper mapper;

    @Override
    public List<HospitalDto> getHospitals() {
        List<Hospital> hospitals = hospitalRepository.findAll();
        List<HospitalDto> dtos = new ArrayList<>(hospitals.size());
        hospitals.forEach(hospital -> {
            List<Review> reviewsForHospital = reviewRepository.findAllByHospitalUuid(hospital.getUuid());
            HospitalDto dto = mapper.map(hospital, HospitalDto.class);
            if (reviewsForHospital.isEmpty()) {
                dto.setRating(0);
            } else {
                Integer rating = 0;
                for (Review review : reviewsForHospital) {
                    rating += review.getRating();
                }
                rating /= reviewsForHospital.size();
                dto.setRating(rating);
            }
            dtos.add(dto);
        });
        return dtos;
    }

    @Override
    public Hospital getHospitalById(UUID uuid) {
        return hospitalRepository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("Не удалось найти больницу с id " + uuid));
    }

    @Override
    public Hospital getHospitalByName(String name) {
        return hospitalRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Не удалось найти больницу с названием " + name));
    }
}
