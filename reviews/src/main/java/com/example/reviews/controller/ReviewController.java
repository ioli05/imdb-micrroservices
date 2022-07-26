package com.example.reviews.controller;

import com.example.reviews.model.Review;
import com.example.reviews.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addReview(@RequestBody Review review) {
        reviewService.addReview(review);
    }

    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    public List<Review> getReviews(@PathVariable String name) {
        return reviewService.getReviews(name);
    }

    @RequestMapping(value = "/avg/{name}", method = RequestMethod.GET)
    public Double getAverageGrade(@PathVariable String name) {
        return reviewService.getAverageGrade(name);
    }
}
