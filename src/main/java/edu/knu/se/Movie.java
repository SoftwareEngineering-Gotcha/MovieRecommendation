package edu.knu.se;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Movie {
	private @Id @GeneratedValue int movieId;
	private String title;
	@Lob
	private ArrayList<Integer> genreId;

	public Movie() {};

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
