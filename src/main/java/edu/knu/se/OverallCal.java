package edu.knu.se;

import java.util.ArrayList;

public class OverallCal {
    private ArrayList<Integer> matching(ArrayList<Integer> userGenreScore, ArrayList<Integer> genreScore){
        // calculate recommendation matrix from user's genre score and all movie's genre score
        if (userGenreScore != null && genreScore != null) {
            ArrayList<Integer> result = new ArrayList();
            return result;
        } return null;
    }

    public ArrayList<Integer> calculate(ArrayList<Integer> userGenreScore){
        // to call matching method. To use user's askPreference method.
        ArrayList<Integer> mgs = new ArrayList<>(); // to make dummy MovieGenreScore
        MovieGenreScore moviegenrescore = new MovieGenreScore(mgs); // to make dummy MovieGenreScore

        ArrayList<Integer> genreScore = (ArrayList<Integer>) moviegenrescore.getGenreScore(); // to make dummy genreScore
        // also in real, we have to get MovieGenreScore and get score to run matching.

        ArrayList<Integer> result = matching(userGenreScore, genreScore); // run matching function to calculate and get MovieList for result of matching.

        return result; // return MovieList
    }
}
