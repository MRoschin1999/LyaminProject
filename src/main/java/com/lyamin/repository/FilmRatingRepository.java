package com.lyamin.repository;

import com.lyamin.pojo.FilmRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FilmRatingRepository extends CrudRepository<FilmRating,Long> {

    @Query(value = "SELECT * FROM film_rating WHERE _user_id=?1",nativeQuery = true)
    Iterable<FilmRating> findFilmRatingByUser(Long _user_id);

}
