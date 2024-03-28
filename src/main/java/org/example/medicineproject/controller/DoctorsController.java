package org.example.medicineproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.medicineproject.dto.DoctorDto;
import org.example.medicineproject.service.api.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/doctors")
public class DoctorsController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getDoctorsByNameAndSurname(DoctorDto dto) {
        return ResponseEntity.ok(doctorService.getDoctorsByNameAndSurname(dto));
    }
}
