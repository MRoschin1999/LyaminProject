package com.lyamin.controller;

import com.lyamin.pojo.Film;
import com.lyamin.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmRestController {

    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/getfilms")
    public Iterable<Film> allFilms(){
        return (filmRepository.findAll());
    }

    @GetMapping("/getfilm/{id}")
    public Film getFilm(@PathVariable(value = "id") Long id){
        return (filmRepository.findById(id).orElse(null));
    }
}
