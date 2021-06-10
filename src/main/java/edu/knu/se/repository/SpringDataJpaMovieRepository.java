package edu.knu.se.repository;

import edu.knu.se.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMovieRepository extends JpaRepository<Movie, Long>, MovieRepository {

}
