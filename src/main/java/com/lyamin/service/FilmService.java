package com.lyamin.service;

import com.lyamin.pojo.Film;
import com.lyamin.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmService {

    final
    FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film getFilmById(Long filmId){
        Optional<Film> film = filmRepository.findById(filmId);
        if(!film.isPresent()){
            throw new NullPointerException();
        }
        return film.get();
    }
}
