package com.noroff.movieapi.repositories;

import com.noroff.movieapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
