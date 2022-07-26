package com.example.movies.service;

import com.example.movies.model.Movie;
import com.example.movies.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MovieService {

    @Autowired
    RestTemplate restTemplate;

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovie(String name) {
        Movie movie = movieRepository.findByName(name);
        //set average by calling the review microservice
        Double rating = restTemplate.getForObject("http://reviews-service/review/avg/" + name , Double.class);
        movie.setRate(rating);
        return movie;
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
