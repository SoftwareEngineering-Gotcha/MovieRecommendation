package edu.knu.se;

public class Movie {
	private int movieId;
	private String title;
	private int genre;
	private String director;
	
	public Movie(int movieId, String title, int genre, String director) {
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.director =director;
	}

	public int getMovieId() {
		return movieId;
	}

	public String getTitle() {
		return title;
	}

	public int getGenre() {
		return genre;
	}

	public String getDirector() {
		return director;
	}
}
