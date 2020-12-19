package com.lyamin.controller;

import com.lyamin.pojo.Film;
import com.lyamin.service.FilmRatingService;
import com.lyamin.service.FilmService;
import com.lyamin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
@RequestMapping("/userTest")
public class UserTestController {

    final FilmService filmService;
    final UserService userService;
    final FilmRatingService filmRatingService;
    public UserTestController(FilmService filmService, UserService userService, FilmRatingService filmRatingService) {
        this.filmService = filmService;
        this.userService = userService;
        this.filmRatingService = filmRatingService;
    }


    @GetMapping("/film/{filmId}/{userId}")
    public String filmPage(Map<String, Object> model, @PathVariable Long filmId, @PathVariable("userId") Long userId){
        Film film = filmService.getFilmById(filmId);
        //Long localUserId = (Long) userId;
        model.put("film", film);
        model.put("userId",userId);
        return "userTest";
    }

    @GetMapping("/result/{userId}")
    public String resultPage(@PathVariable Long userId){
        return "result";
    }

    @PostMapping("/addFilm/{filmId}/{userId}")
    public ModelAndView filmPage(@PathVariable Long filmId, @PathVariable Long userId, @RequestParam Integer rating){
        filmRatingService.saveRating(filmId, userId, rating);

        if(filmId<11) {
            return new ModelAndView("redirect:/userTest/film/" + (filmId + 1) + "/" + userId);
        }
        else {
            return new ModelAndView("redirect:/userTest/result/" + userId);
        }
    }

    @PostMapping("/startTest")
    public ModelAndView startTest() {
       ModelAndView modelAndView = new ModelAndView("redirect:/userTest/film/1/"+ userService.addUser().getId());
//        modelAndView.addObject("userId", userService.addUser());
        return modelAndView;
    }
}