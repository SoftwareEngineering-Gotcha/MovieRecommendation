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
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public boolean setMovieList(ArrayList<Integer> movieList) {
        this.movieList = movieList;
        if(this.movieList != null) {
            return true;
        }
        return false;
    }
}