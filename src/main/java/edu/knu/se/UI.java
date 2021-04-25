package edu.knu.se;

import java.util.ArrayList;

public class UI {
    public boolean provideMovieInfo(ArrayList<Integer> userMovieList){
        // print recommended user list
        if(userMovieList != null)
            return true;
        return false;
    }
    public ArrayList<Integer> askPreferenceWindow(){
        // get user genre score from user
        ArrayList<Integer> result = new ArrayList(); // list provided by user(ex) scanner, etc.)
        return result;
    }
}
