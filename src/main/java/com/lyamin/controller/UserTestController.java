package com.lyamin.controller;

import com.lyamin.pojo.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController("/userTest")
public class UserTestController {

    @GetMapping("/film/{filmId}")
    public String filmPage(Model model, @PathVariable Integer filmId){
        Film film;
        //сходили в базу взялми фильм
        model.addAllAttributes("film", film);
        return "userTest";
    }

    @PostMapping("/addFilm/{filmId}")
    public String filmPage(@PathVariable Integer filmId, @RequestParam Integer rating){
        Film film;
        //сходили в базу взялми фильм
        return "userTest";
    }
}
