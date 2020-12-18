package com.lyamin.controller;

import com.lyamin.pojo.FilmRating;
import com.lyamin.pojo.User;
import com.lyamin.repository.FilmRatingRepository;
import com.lyamin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingRestController {

    @Autowired
    FilmRatingRepository filmRatingRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("getuserrating/{id}")
    public Iterable<FilmRating> getUserRating(@PathVariable(name = "id") Long id){
        Iterable<FilmRating> filmRatings = filmRatingRepository.findFilmRatingByUser(id);
        User user = userRepository.findById(id).orElse(null);
        return filmRatings;
    }

}
