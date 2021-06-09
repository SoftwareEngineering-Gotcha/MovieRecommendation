package edu.knu.se.domain;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name="FOR_MOVIE_SEQ",
        sequenceName = "seq_movie",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "movies")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOR_MOVIE_SEQ")
    private Long movieid;

    private String title;

    private String genres;

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getGenres() {
        return genres;
    }

    public void setMovieid(Long movieid) {
        this.movieid = movieid;
    }

    public void setMoviename(String moviename) {
        this.title = moviename;
    }

    public Long getMovieid() {
        return movieid;
    }

    public String getMoviename() {
        return title;
    }

    public Movie() {
    }
}
