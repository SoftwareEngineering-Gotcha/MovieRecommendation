package edu.knu.se.controller;
import java.io.*;

import edu.knu.se.domain.Movie;
import edu.knu.se.domain.Ratings;
import edu.knu.se.domain.User;
import edu.knu.se.repository.RatingsRepository;
import edu.knu.se.repository.UserRepository;
import edu.knu.se.service.MovieService;
import edu.knu.se.service.RatingsService;
import edu.knu.se.service.UserService;
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
    @PutMapping("")
    String putUser(@RequestParam(name = "uid") String uid, @RequestParam(name="passwd") String pwd) {
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

    // R3
    @DeleteMapping("/{userid}")
    public String deleteUid(@PathVariable(name = "userid") String uid) {
        String result = "FAILED";
        if((userService.ExistsOnebyUserid(uid))) {
            userService.deleteByUserid(uid);
            result = "SUCCESS";
        }
        return "{\"result\":\"" + result + "\"}";
    }

    // R4
    @GetMapping("")
    public List<User> all(){
        return userService.findMember();
    }

    // R5
    @GetMapping("/_count_")
    public int count(){
        List<User> list = userService.findMember();
        return list.size();
    }

    //R6
    @PutMapping("/{uid}/ratings")
    String putRating(@PathVariable("uid")String uid,@RequestParam("movie") Long movie_id, @RequestParam("rating") float rating) {
        String result = "FAILED";
        Ratings temp = new Ratings();

        List<Ratings> list = ratingsService.findByUserid(uid); // uid를 바탕으로 해당 uid가 평가한 ratings들을 불러옴

        if(!(userService.ExistsOnebyUserid(uid))) // 없는 User이면
            return "{\"result\":"+ result +"\"}"; // 실패 반환

        if(!(movieService.ExistsById(movie_id))) // 없는 movie이면
            return "{\"result\":"+ result +"\"}"; // 실패 반환

        if(!(rating >= 1 && rating <= 5)) return "{\"result\":"+result+"\"}"; // 1 미만 5 초과
        if((rating%0.5) != 0.0) return "{\"result\":"+result+"\"}"; // n.0 또는 n.5가 아님



        for(int i = 0; i < list.size(); i++) { // uid에 해당하는 User가 평가한 영화 목록 중에서 이미 평가한 영화인지 확인
            temp = list.get(i);
            if(temp.getMovieid() == movie_id) { // 같은 것이 있으면
                temp = ratingsService.findByUseridandMovieid(uid, movie_id); // 그 부분만 받아외서
                temp.setRating(rating); // rating 설정
                long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
                temp.setTimestamp(timestamp / 1000); // timestamp 설정
                result = "SUCCESS"; // 성공
                ratingsService.join(temp); // DB에 저장
                return "{\"result\":"+ result +"\"}";
            }
        }

        // 다 해당사항 없으면 처음으로 영화를 평가함
        temp.setUserid(uid); // uid 설정
        temp.setMovieid(movie_id); // movie_id 설정
        temp.setRating(rating); // rating 설정
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        temp.setTimestamp(timestamp / 1000); // timestamp 설정
        result = "SUCCESS"; // 성공
        ratingsService.join(temp); // DB에 저장

        return "{\"result\":"+ result +"\"}";
    }

    // R7
    @GetMapping("/{userid}/ratings")
    List<Ratings> return_rating(@PathVariable(name = "userid") String userid) {
        if(userService.ExistsOnebyUserid(userid))
        {
            List<Ratings> list = ratingsService.findByUserid(userid);
            return list;
        }
        return null;
    }
}
