package com.example.movies.controller;

import com.example.movies.model.Movie;
import com.example.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/{name}")
    public Movie getMovie(@PathVariable String name) {
        return movieService.getMovie(name);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }
}
