package edu.knu.se.repository;

import edu.knu.se.domain.Ratings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RatingsRepository {

    @Query(value = "select * from ratings where userid = ?1",nativeQuery=true)
    public List<Ratings> findByUserid(
            Long userid
    );

    @Query(value = "select * from ratings "
            +"where userid= ?1 and"
            +"movieid= ?2 and"
            +"rating= ?3", nativeQuery = true
    )
    public boolean isexists( Long userid,
                      Long movieid,
                      Float rating
    );

    @Query(value = "select * from ratings "
            +"where userid= ?1 and"
            +"movieid= ?2 and"
            +"rating= ?3", nativeQuery = true
    )
    public Optional<Ratings> findByAll(Long userid,
                                 Long movieid,
                                 Float rating
    );

    @Query(value = "select * from ratings where userid = ?1 and movieid= ?2",nativeQuery = true)
    public Ratings findByUseridandMovieid(Long userid, Long movieid);

    /*
    @Query("from ratings "
            +"where userid= :userid and"
    )
    void deleteByUserid(@Param("userid") Long userid);

     */
    Ratings save(Ratings ratings);
    List<Ratings> findAll();
}
