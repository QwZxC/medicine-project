package org.example.medicineproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.medicineproject.dto.CreateReviewDto;
import org.example.medicineproject.dto.ReviewDto;
import org.example.medicineproject.entity.Review;
import org.example.medicineproject.repository.ReviewRepository;
import org.example.medicineproject.service.api.HospitalService;
import org.example.medicineproject.service.api.ReviewService;
import org.example.medicineproject.service.api.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ReviewDto createReview(CreateReviewDto dto) {
        Review review = mapper.map(dto, Review.class);
        review.setUuid(UUID.randomUUID());
        review.setHospital(hospitalService.getHospitalByName(dto.getHospitalName()));
        review.setCreator(userService.getCurrentUser());
        return mapper.map(reviewRepository.save(review), ReviewDto.class);
    }

    @Override
    public List<ReviewDto> getReviewsForHospital(UUID hospitalUuid) {
        List<Review> reviews = reviewRepository.findAllByHospitalUuid(hospitalUuid);
        List<ReviewDto> responseBody = new ArrayList<>(reviews.size());
        reviews.forEach(review -> responseBody.add(mapper.map(review, ReviewDto.class)));
        return responseBody;
    }
}
