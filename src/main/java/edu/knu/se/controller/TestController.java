package edu.knu.se.controller;

import edu.knu.se.domain.Movie;
import edu.knu.se.domain.MovieGenreScore;
import edu.knu.se.service.MovieGenreScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    private final MovieGenreScoreService mgs;

    @Autowired
    public TestController(MovieGenreScoreService mgs) {
        this.mgs = mgs;
    }

    @GetMapping("/{userid}")
    String return_mgs(@PathVariable("userid") Long userid){
        mgs.getscorebyrating(userid);

        return "SUCCESS";
    }

    @GetMapping("/{userid}/movie_list")
    List<Movie> return_list(@PathVariable("userid") Long userid){
        mgs.getscorebyrating(userid);
        return mgs.getRecommendedMovieList(userid);
    }
}
