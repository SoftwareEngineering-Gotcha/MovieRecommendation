package edu.knu.se.service;

import edu.knu.se.domain.Ratings;
import edu.knu.se.repository.RatingsRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class RatingsService {
    private final RatingsRepository ratingsRepository;
    List<Ratings> data;
    public RatingsService(RatingsRepository ratingsRepository) {
        this.ratingsRepository = ratingsRepository;
    }

    public long join(Ratings ratings){
       // validateDuplicateRatings(ratings);

        ratingsRepository.save(ratings);
        return ratings.getUserid();
    }

    private void validateDuplicateRatings(Ratings ratings){
        ratingsRepository.findByAll(ratings.getUserid(),ratings.getMovieid()
        ,ratings.getRating()).ifPresent(m->{
            throw new IllegalStateException("중복 rating은 불가합니다.");
        });

    }

    public Ratings findByUseridandMovieid(Long userid, Long movieid)
    {
        return ratingsRepository.findByUseridandMovieid(userid,movieid);
    }
    /*
    public void deleteByUserid(Long Userid){
        ratingsRepository.deleteByUserid(Userid);
    }
*/
    public List<Ratings> findByUserid(Long userid){return ratingsRepository.findByUserid(userid);}
    public List<Ratings> findAll() {
        return ratingsRepository.findAll();
    }
}
