package edu.knu.se;

import java.util.ArrayList;

public class User {
    private String id;
    private String name;
    private ArrayList<Integer> genreScore;
    private ArrayList<Integer> movieList;

    public User(String id, String name, ArrayList<Integer> genreScore, ArrayList<Integer> movieList){
        this.id = id;
        this.name = name;
        this.genreScore = genreScore;
        this.movieList = movieList;
    }

    public boolean askPreference() {
        if(genreScore != null) {
            return true;
        } else {
            return false;
        }
        //선호도 조사
    }
    /*
    public String[] recommendationInfo() {
        return movieList;
    }
    public boolean provideMovieInfo() {
        if(movieList != null) {
            return true;
        }else {
            return false;
        }
        //영화 있는지 없는지만 확인
    }

     */
}