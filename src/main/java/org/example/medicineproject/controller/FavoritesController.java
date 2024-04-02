package org.example.medicineproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.medicineproject.dto.DoctorDto;
import org.example.medicineproject.dto.HospitalDto;
import org.example.medicineproject.service.api.FavoriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/favorites")
public class FavoritesController {

    private final FavoriteService favoriteService;

    @GetMapping("doctors")
    public ResponseEntity<List<DoctorDto>> getFavoriteDoctors() {
        return ResponseEntity.ok(favoriteService.getFavoriteDoctors());
    }

    @GetMapping("hospitals")
    public ResponseEntity<List<HospitalDto>> getFavoriteHospitals() {
        return ResponseEntity.ok(favoriteService.getFavoriteHospitals());
    }

    @PostMapping("doctors")
    public ResponseEntity<DoctorDto> addFavoriteDoctor(@RequestBody UUID doctorUuid) {
        return ResponseEntity.ok(favoriteService.createFavoriteDoctor(doctorUuid));
    }

    @PostMapping("hospitals")
    public ResponseEntity<HospitalDto> addFavoriteHospital(@RequestBody UUID hospitalUuid) {
        return ResponseEntity.ok(favoriteService.createFavoriteHospital(hospitalUuid));
    }
}
