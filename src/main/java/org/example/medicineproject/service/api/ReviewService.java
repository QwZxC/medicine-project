package org.example.medicineproject.service.api;

import org.example.medicineproject.dto.CreateReviewDto;
import org.example.medicineproject.entity.Review;

import java.util.List;
import java.util.UUID;

public interface ReviewService {

    Review createReview(CreateReviewDto dto);

    List<Review> getReviewsForHospital(UUID uuid);
}
