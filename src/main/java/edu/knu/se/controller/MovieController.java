package edu.knu.se.controller;

import edu.knu.se.domain.Movie;
import edu.knu.se.domain.User;
import edu.knu.se.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    MovieController(MovieService movieService) {this.movieService = movieService;}

    @GetMapping("")
    List<Movie> all(){return movieService.findMember();}

    @GetMapping("_count_")
    int count(){
        List<Movie> list = movieService.findMember();
        return list.size();
    }

    @PutMapping("/")
    String putUser(@RequestParam Long movieid, @RequestParam(name="moviename") String moviename) {
        String result = "FAILED";
        if(!(movieService.ExistsById(movieid))) {
            Movie newUser = new Movie();
            newUser.setMovieid(movieid);
            newUser.setMoviename(moviename);
            movieService.join(newUser);
            result = "SUCCESS";
        } else {
            movieService.findOne(movieid)
                    .map(movie -> {
                        movie.setMovieid(movieid);
                        movie.setMoviename(moviename);
                        movieService.join(movie);
                        return "";
                    });
            result = "SUCCESS";
        }
        return "{\"result\":"+result+"\"}";
    }
}
*/