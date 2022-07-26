package com.example.reviews.repo;

import com.example.reviews.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, String> {

    List<Review> findAllByName(String name);
}
