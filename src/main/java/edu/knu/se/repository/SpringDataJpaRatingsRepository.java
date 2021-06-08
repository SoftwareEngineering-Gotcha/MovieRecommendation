package edu.knu.se.repository;

import edu.knu.se.domain.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataJpaRatingsRepository extends JpaRepository<Ratings, Long>,RatingsRepository {


}
