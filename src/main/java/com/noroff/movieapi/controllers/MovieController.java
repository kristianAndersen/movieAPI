package com.noroff.movieapi.controllers;


import com.noroff.movieapi.models.Movie;
import com.noroff.movieapi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;


    @GetMapping()
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movie = movieRepository.findAll();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(movie, status);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie returnMovie = movieRepository.save(movie);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(returnMovie, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateAddress(@RequestBody Movie movie, @PathVariable Long id){
        HttpStatus status;
        Movie retAdd = new Movie();
        if(!Objects.equals(id, movie.getId())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(retAdd, status);
        }
        retAdd = movieRepository.save(movie);
        status = HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(retAdd, status);
    }
}
