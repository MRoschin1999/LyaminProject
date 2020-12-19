package com.lyamin.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class FilmRating {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id")
    private Film film;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "_user_id")
    private User user;
    @Column(name = "imdb_title_id")
    private String imdbTitleId;
    private int rating;

    public FilmRating(long id, Film film, User user, int rating) {
        this.id = id;
        this.film = film;
        this.user = user;
        this.rating = rating;
        this.imdbTitleId = film.getImdbTitleId();
    }

    public FilmRating(){

    }

}
