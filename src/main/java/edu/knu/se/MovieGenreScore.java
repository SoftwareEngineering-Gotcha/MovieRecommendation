package edu.knu.se;

import java.util.ArrayList;

public class MovieGenreScore {
	private ArrayList<Integer> genreScore;

	public MovieGenreScore(ArrayList<Integer> genreScore) { // genre score for all movies
		this.genreScore = genreScore;
	}
	public ArrayList<Integer> getGenreScore(){
		return genreScore;
	}
}
