package edu.knu.se;

import java.util.ArrayList;

public class Movie {
	private int movieId;
	private String title;
	private ArrayList<Integer> genreId;

	public Movie(int movieId, String title, ArrayList<Integer> genreId) {
		this.movieId = movieId;
		this.title = title;
		this.genreId = genreId;
	}

	public int getMovieId() {
		return movieId;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<Integer> getGenreId() {
		return genreId;
	}

}
