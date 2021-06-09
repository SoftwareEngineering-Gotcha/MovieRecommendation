package edu.knu.se.controller;


import edu.knu.se.domain.Ratings;
import edu.knu.se.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingsController {
    private final RatingsService ratingsService;

    @Autowired
    RatingsController(RatingsService ratingsService){
        this.ratingsService= ratingsService;
    }

    @GetMapping("/_count_")
    int count(){
        List<Ratings> list = ratingsService.findAll();
        return list.size();
    }

    @GetMapping("/")
    List<Ratings> return_ratings(@RequestParam String userid) {
        return ratingsService.findByUserid(userid);
    }

    @PutMapping("/")
    String putRatings(@RequestParam(name = "userid") String uid, @RequestParam(name = "movieid")
                      Long mid,@RequestParam(name="rating")Float rating)
    {
        String result = "SUCCESS";

        Ratings newRatings = new Ratings();
        newRatings.setRating(rating);
        newRatings.setMovieid(mid);
        newRatings.setUserid(uid);
        ratingsService.join(newRatings);

        return result;

    }

    @GetMapping("/exists/")
    String isit(@RequestParam(name = "userid") String uid, @RequestParam(name = "movieid") Long movieid)
    {
        Ratings ratings = ratingsService.findByUseridandMovieid(uid,movieid);

        String str1 = new String("userid : " + ratings.getUserid()+" movieid : " + Long.toString(ratings.getMovieid()));

        return str1;
    }
}
