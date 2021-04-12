package edu.knu.se;

import java.util.ArrayList;
import java.util.List;

public class OverallCal {
    ArrayList<Integer> ugl = new ArrayList<>();
    ArrayList<Integer> ml = new ArrayList<>();
    ArrayList<Integer> mgs = new ArrayList<>();
    User user = new User("A", "user", ugl, ml);
    MovieGenreScore moviegenrescore = new MovieGenreScore(mgs);

    boolean matching(List<Integer> userGenreScore, List<Integer> genreScore){
        user.setMovieList(ml);
        if(user.getMovieList().isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    boolean calculate(){
        if(moviegenrescore.getGenreScore()){
            return true;
        }else{
            return false;
        }
    }

}
