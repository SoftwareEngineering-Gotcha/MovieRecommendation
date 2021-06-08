package edu.knu.se.repository;

import edu.knu.se.domain.MovieGenreScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMovieGenreScoreRepository extends JpaRepository<MovieGenreScore, Long>, MovieGenreScoreRepository {
    @Override
    Optional<MovieGenreScore> findByUserid(Long userid);
    @Override
    boolean existsByUserid(Long userid);
    @Override
    void deleteByUserid(Long Userid);
}
