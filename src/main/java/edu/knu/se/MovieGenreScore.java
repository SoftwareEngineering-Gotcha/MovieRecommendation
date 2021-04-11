package edu.knu.se;

import java.util.ArrayList;
import java.util.List;

public class MovieGenreScore {
	private ArrayList<Integer> genreScore;
	
	public MovieGenreScore(ArrayList<Integer> genreScore) {
		this.genreScore = genreScore;
	}
	public boolean getGenreScore(){
		if(genreScore == null) return false;
		return true;
	}
	/*
	public boolean matching(int userScore, int genreScore) {
		return userScore==genreScore;
	}
	 */
}
