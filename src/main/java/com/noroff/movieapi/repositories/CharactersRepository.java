package com.noroff.movieapi.repositories;

import com.noroff.movieapi.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharactersRepository extends JpaRepository<Character,Long> {
}
