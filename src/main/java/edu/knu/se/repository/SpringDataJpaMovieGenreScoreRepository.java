package edu.knu.se.repository;

import edu.knu.se.domain.MovieGenreScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMovieGenreScoreRepository extends JpaRepository<MovieGenreScore, Long>, MovieGenreScoreRepository {
    @Override
    Optional<MovieGenreScore> findByUserid(String userid);
    @Override
    boolean existsByUserid(String userid);
    @Override
    void deleteByUserid(String Userid);
}
