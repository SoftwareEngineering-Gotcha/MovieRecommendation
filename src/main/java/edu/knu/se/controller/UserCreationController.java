package edu.knu.se.controller;

import edu.knu.se.domain.User;
import edu.knu.se.service.MovieService;
import edu.knu.se.service.RatingsService;
import edu.knu.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserCreationController {
    private final UserService userService;
    private final MovieService movieService;
    private final RatingsService ratingsService;

    List<String> data;
    @Autowired
    UserCreationController(UserService userService, MovieService movieService, RatingsService ratingsService){
        this.userService = userService;
        this.movieService = movieService;
        this.ratingsService = ratingsService;

    }
    @PutMapping("/{userid}/")
    String putUser(@PathVariable(name = "userid") String uid, @RequestParam(name="passwd") String pwd) {
        String result = "FAILED";

        if(!(userService.ExistsOnebyUserid(uid))) {
            User newUser = new User();
            newUser.setUserid(uid);
            newUser.setPasswd(pwd);
            userService.join(newUser);
            result = "SUCCESS";
        }

        return "{\"result\":"+result+"\"}";
    }

}
