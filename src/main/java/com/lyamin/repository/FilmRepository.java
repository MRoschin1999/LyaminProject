package com.lyamin.repository;

import com.lyamin.pojo.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {

}
