package com.lyamin.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter(lazy = true) @Setter @NoArgsConstructor
public class FilmRating {
    private long filmID;
    private Rating rating;

    public FilmRating(long filmID, Rating rating) {
        this.filmID = filmID;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmRating)) return false;
        FilmRating that = (FilmRating) o;
        return filmID == that.filmID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmID);
    }
}
