package edu.knu.se;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class User {
    private @Id String uid;
    private String passwd;
    @Lob
    private ArrayList<Integer> userGenreScore;
    @Lob
    private ArrayList<Integer> movieList;

    public User() {}

    public User(String uid, String passwd, ArrayList<Integer> genreScore, ArrayList<Integer> movieList){
        this.uid = uid;
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

    public String getUid(){
        return uid;
    }

    public void setUid(String id){
        this.uid = uid;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
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
        return Objects.hash(this.uid, this.passwd, this.userGenreScore, this.movieList);
    }

    @Override
    public String toString() {
        return "{" + "\"uid\" = \"" + this.uid + "\", \"passwd\" = \"" + this.passwd + "\"}";
    }
}