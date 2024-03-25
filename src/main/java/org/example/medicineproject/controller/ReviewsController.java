package org.example.medicineproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.medicineproject.dto.CreateReviewDto;
import org.example.medicineproject.dto.ReviewDto;
import org.example.medicineproject.entity.Review;
import org.example.medicineproject.service.api.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/reviews")
public class ReviewsController {

    private final ReviewService reviewService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ReviewDto>> getReviewsForHospital(@RequestParam UUID hospitalUuid) {
        List<Review> reviews = reviewService.getReviewsForHospital(hospitalUuid);
        List<ReviewDto> responseBody = new ArrayList<>(reviews.size());
        reviews.forEach(review -> responseBody.add(mapper.map(review, ReviewDto.class)));
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody CreateReviewDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.map(reviewService.createReview(dto), ReviewDto.class));
    }
}
