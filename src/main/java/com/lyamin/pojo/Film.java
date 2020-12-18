package com.lyamin.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name="film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String imdbTitleId;
    private String name;
    private String preview;
    private float avgRating;

    public Film(long id, String name, String imdbTitleId, String preview, float avgRating) {
        this.id = id;
        this.name = name;
        this.imdbTitleId = imdbTitleId;
        this.preview = preview;
        this.avgRating = avgRating;
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
