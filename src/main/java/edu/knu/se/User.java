package edu.knu.se;

import java.util.ArrayList;

public class User {
    private String id;
    private String name;
    private ArrayList<Integer> userGenreScore;
    private ArrayList<Integer> movieList;

    public User(String id, String name, ArrayList<Integer> genreScore, ArrayList<Integer> movieList){
        this.id = id;
        this.name = name;
        this.userGenreScore = genreScore;
        this.movieList = movieList;
    }

    public boolean askPreference() {
        if(userGenreScore != null) {
            return true;
        } else {
            return false;
        }
        //선호도 조사
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Integer> getUserGenreScore(){
        return userGenreScore;
    }

    public void setMovieList(ArrayList<Integer> movieList){
        this.movieList = movieList;
    }

    public ArrayList<Integer> getMovieList(){
        return movieList;
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