package com.example.reviews.service;

import com.example.reviews.model.Review;
import com.example.reviews.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    public List<Review> getReviews(String name) {
        return reviewRepository.findAllByName(name);
    }

    public Double getAverageGrade(String name) {
        return reviewRepository.findAllByName(name).stream().collect(Collectors.averagingDouble(Review::getGrade));
    }
}
