package edu.knu.se.repository;

import edu.knu.se.domain.Movie;
import edu.knu.se.domain.MovieGenreScore;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieGenreScoreRepository {
        MovieGenreScore save(MovieGenreScore mgs);

        @Query(value = "select * from mgs where userid = ?1", nativeQuery = true)
        Optional<MovieGenreScore> findByUserid(Long userid);

        @Query(value = "select 'true' from dual where exists(select * from mgs where userid = ?1) union select 'false' from dual where not exists"+
                " (select * from mgs where userid = ?1)", nativeQuery = true)
        boolean existsByUserid(Long userid);

        @Query(value = "delete from mgs where userid = ?1",nativeQuery = true)
        void deleteByUserid(Long Userid);

        @Query(value = "update mgs set id = ?1,userid = ?2,action = ?3,animation = ?4,adventure = ?5,children = ?6,comedy = ?7," +
                "crime = ?8,documentary = ?9,drama = ?10,fantasy = ?11,film_noir = ?12,horror = ?13,musical = ?14,mystery = ?15," +
                "romance = ?16,scifi = ?17,thriller = ?18,war = ?19,western = ?20 where userid = ?2", nativeQuery = true)
        void update_set(Long id,Long userid, Float action, Float animation, Float adventure, Float children, Float comedy, Float crime, Float documentary,
                        Float drama, Float fantasy, Float film_noir, Float horror, Float musical, Float mystery, Float romance, Float scifi, Float thriller, Float war
        ,Float western);

        void deleteById(Long Userid);
        List<MovieGenreScore> findAll();
}
