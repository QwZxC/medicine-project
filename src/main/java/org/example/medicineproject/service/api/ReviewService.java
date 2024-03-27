package org.example.medicineproject.service.api;

import org.example.medicineproject.dto.CreateReviewDto;
import org.example.medicineproject.dto.ReviewDto;

import java.util.List;
import java.util.UUID;

public interface ReviewService {

    ReviewDto createReview(CreateReviewDto dto);

    List<ReviewDto> getReviewsForHospital(UUID uuid);
}
