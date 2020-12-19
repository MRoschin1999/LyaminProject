package com.lyamin.service;

import com.lyamin.pojo.Film;
import com.lyamin.pojo.FilmRating;
import com.lyamin.pojo.User;
import com.lyamin.repository.FilmRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmRatingService {
    final
    FilmRatingRepository filmRatingRepository;

    final
    FilmService filmService;

    final
    UserService userService;
    public FilmRatingService(FilmRatingRepository filmRatingRepository, FilmService filmService, UserService userService) {
        this.filmRatingRepository = filmRatingRepository;
        this.filmService = filmService;
        this.userService = userService;
    }

    public void saveRating(Long filmId, Long userId, Integer rating){
        long maxId = 0L;
        Iterable<FilmRating> filmRatings = filmRatingRepository.findAll();
        for (FilmRating value : filmRatings) {
            long id = value.getId();
            if (maxId < id) {
                maxId = id;
            }
        }
        maxId++;
        Film film = filmService.getFilmById(filmId);
        User user = userService.getUserById(userId);

        FilmRating filmRating = new FilmRating(maxId, film, user, rating);
        filmRatingRepository.save(filmRating);
    }
}
