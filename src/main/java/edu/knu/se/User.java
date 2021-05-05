package edu.knu.se;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class User {
    private @Id String id;
    private String name;
    private String passwd;
    @Lob
    private ArrayList<Integer> userGenreScore;
    @Lob
    private ArrayList<Integer> movieList;

    public User() {}

    public User(String id, String name, String passwd, ArrayList<Integer> genreScore, ArrayList<Integer> movieList){
        this.id = id;
        this.name = name;
        this.passwd = passwd;
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

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPasswd() { return passwd; }

    public boolean setMovieList(ArrayList<Integer> movieList) {
        this.movieList = movieList;
        if(this.movieList != null) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.userGenreScore, this.movieList);
    }

    @Override
    public String toString(){
        return "USER{" + "id= " + this.id + ", name= " + this.name + "}";
    }
}