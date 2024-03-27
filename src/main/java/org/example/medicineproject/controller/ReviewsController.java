package org.example.medicineproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.medicineproject.dto.CreateReviewDto;
import org.example.medicineproject.dto.ReviewDto;
import org.example.medicineproject.service.api.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/reviews")
public class ReviewsController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDto>> getReviewsForHospital(@RequestParam UUID hospitalUuid) {
        return ResponseEntity.ok(reviewService.getReviewsForHospital(hospitalUuid));
    }

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody CreateReviewDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.createReview(dto));
    }
}
