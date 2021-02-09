package com.noroff.movieapi.controllers;

import com.noroff.movieapi.models.Character;
import com.noroff.movieapi.repositories.CharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @CrossOrigin(origins = "*")
    @RequestMapping("/api/v1/characters")

    public class CharacterController {

        @Autowired
        private CharactersRepository charactersRepository;

        @GetMapping()
        public ResponseEntity<List<Character>> getAllCharacters() {
            List<Character> character = charactersRepository.findAll();
            HttpStatus status = HttpStatus.OK;
            return new ResponseEntity<>(character, status);
        }

        @PostMapping
        public ResponseEntity<Character> addCharacter(@RequestBody Character character) {
            Character returnCharacter = charactersRepository.save(character);
            HttpStatus status = HttpStatus.CREATED;
            return new ResponseEntity<>(returnCharacter, status);
        }
    }

