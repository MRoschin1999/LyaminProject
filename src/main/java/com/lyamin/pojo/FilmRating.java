package com.lyamin.pojo;

import java.util.Objects;

public class FilmRating {
    private long filmID;
    private Rating rating;

    public  FilmRating(){

    }

    public FilmRating(long filmID, Rating rating) {
        this.filmID = filmID;
        this.rating = rating;
    }


    public long getFilmID() {
        return filmID;
    }

    public void setFilmID(long filmID) {
        this.filmID = filmID;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmRating)) return false;
        FilmRating that = (FilmRating) o;
        return getFilmID() == that.getFilmID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFilmID());
    }
}
