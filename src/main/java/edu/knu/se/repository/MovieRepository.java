package edu.knu.se.repository;

import edu.knu.se.domain.Movie;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    Movie save(Movie user);


    Optional<Movie> findById(Long id);
    boolean existsById(Long id);
    void deleteById(Long id);


    @Query(value = "select * from movie where movieid = ?1", nativeQuery = true)
    Optional<Movie> findByMovieId(Long movieid);
    List<Movie> findAll();

}
