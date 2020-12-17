package com.lyamin.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String genre;
    private String preview;
    private float avgRating;
    private int userRating;

    public Film(long id, String name, String genre, String preview, float avgRating, int userRating) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.preview = preview;
        this.avgRating = avgRating;
        this.userRating = userRating;
    }

    public Film() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;
        return id == film.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
