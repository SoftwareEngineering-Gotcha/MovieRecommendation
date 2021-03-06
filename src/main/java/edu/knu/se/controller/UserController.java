package edu.knu.se.controller;
import java.io.*;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import edu.knu.se.domain.Movie;
import edu.knu.se.domain.Ratings;
import edu.knu.se.domain.User;
import edu.knu.se.repository.RatingsRepository;
import edu.knu.se.repository.UserRepository;
import edu.knu.se.service.MovieService;
import edu.knu.se.service.RatingsService;
import edu.knu.se.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final MovieService movieService;
    private final RatingsService ratingsService;

    List<String> data;
    @Autowired
    public UserController(UserService userService, MovieService movieService, RatingsService ratingsService){
        this.userService = userService;
        this.movieService = movieService;
        this.ratingsService = ratingsService;

    }

    // R2
    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("")
    public JSONObject putUser(@RequestParam(name = "uid") String uid, @RequestParam(name="passwd") String pwd) {
        String result = "FAILED";

        if(!(userService.ExistsOnebyUserid(uid))) {
            User newUser = new User();
            newUser.setUserid(uid);
            newUser.setPasswd(pwd);
            userService.join(newUser);
            result = "SUCCESS";
        }

        JSONObject output = new JSONObject();
        output.put("result", result);
        return output;
    }

    // R3
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/{userid}")
    public JSONObject deleteUid(@PathVariable(name = "userid") String uid) {
        String result = "FAILED";
        if((userService.ExistsOnebyUserid(uid))) {
            userService.deleteByUserid(uid);
            result = "SUCCESS";
        }

        JSONObject output = new JSONObject();
        output.put("result", result);
        return output;
    }

    // R4
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("")
    public List<User> all(){
        return userService.findMember();
    }

    // R5
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/_count_")
    public int count(){
        List<User> list = userService.findMember();
        return list.size();
    }

    //R6
    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/{uid}/ratings")
    public JSONObject putRating(@PathVariable("uid")String uid,@RequestParam("movie") Long movie_id, @RequestParam("rating") float rating) {
        String result = "FAILED";
        Ratings temp = new Ratings();

        List<Ratings> list = ratingsService.findByUserid(uid); // uid??? ???????????? ?????? uid??? ????????? ratings?????? ?????????

        if(!(userService.ExistsOnebyUserid(uid))) { // ?????? User??????
            JSONObject output = new JSONObject();
            output.put("result", result);
            return output; // ?????? ??????
        }
        
        if(!(movieService.ExistsById(movie_id))) {// ?????? movie??????
            JSONObject output = new JSONObject();
            output.put("result", result);
            return output; // ?????? ??????
        }

        if(!(rating >= 1 && rating <= 5)) { // 1 ?????? 5 ??????
            JSONObject output = new JSONObject();
            output.put("result", result);
            return output; // ?????? ??????
        }
        if((rating%0.5) != 0.0) { // n.0 ?????? n.5??? ??????
            JSONObject output = new JSONObject();
            output.put("result", result);
            return output; // ?????? ??????
        }



        for(int i = 0; i < list.size(); i++) { // uid??? ???????????? User??? ????????? ?????? ?????? ????????? ?????? ????????? ???????????? ??????
            temp = list.get(i);
            if(temp.getMovieid() == movie_id) { // ?????? ?????? ?????????
                temp = ratingsService.findByUseridandMovieid(uid, movie_id); // ??? ????????? ????????????
                temp.setRating(rating); // rating ??????
                long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
                temp.setTimestamp(timestamp / 1000); // timestamp ??????
                result = "SUCCESS"; // ??????
                ratingsService.join(temp); // DB??? ??????
                JSONObject output = new JSONObject();
                output.put("result", result);
                return output;
            }
        }

        // ??? ???????????? ????????? ???????????? ????????? ?????????
        temp.setUserid(uid); // uid ??????
        temp.setMovieid(movie_id); // movie_id ??????
        temp.setRating(rating); // rating ??????
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        temp.setTimestamp(timestamp / 1000); // timestamp ??????
        result = "SUCCESS"; // ??????
        ratingsService.join(temp); // DB??? ??????

        JSONObject output = new JSONObject();
        output.put("result", result);
        return output;
    }

    // R7
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/{userid}/ratings")
    public List<Ratings> return_rating(@PathVariable(name = "userid") String userid) {
        if(userService.ExistsOnebyUserid(userid))
        {
            List<Ratings> list = ratingsService.findByUserid(userid);
            return list;
        }
        return null;
    }
}
