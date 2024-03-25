package org.example.medicineproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.medicineproject.dto.CreateReviewDto;
import org.example.medicineproject.entity.Review;
import org.example.medicineproject.repository.ReviewRepository;
import org.example.medicineproject.service.api.HospitalService;
import org.example.medicineproject.service.api.ReviewService;
import org.example.medicineproject.service.api.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final HospitalService hospitalService;
    private final UserService userService;
    private final ModelMapper mapper;

    @Override
    public Review createReview(CreateReviewDto dto) {
        Review review = mapper.map(dto, Review.class);
        review.setUuid(UUID.randomUUID());
        review.setHospital(hospitalService.getHospitalByName(dto.getHospitalName()));
        review.setCreator(userService.getCurrentUser());
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsForHospital(UUID hospitalUuid) {
        return reviewRepository.findAllByHospitalUuid(hospitalUuid);
    }
}
