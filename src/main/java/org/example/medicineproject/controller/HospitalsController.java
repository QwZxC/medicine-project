package org.example.medicineproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.medicineproject.dto.HospitalDto;
import org.example.medicineproject.service.api.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/hospitals")
public class HospitalsController {

    private final HospitalService hospitalService;

    @GetMapping
    public ResponseEntity<List<HospitalDto>> getAllHospitals() {
        return ResponseEntity.ok(hospitalService.getHospitals());
    }
}
