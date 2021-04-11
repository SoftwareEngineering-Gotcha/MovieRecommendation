package edu.knu.se;

public class Movie {
	private int movieId;
	private String title;
	private String genre;
	private String director;
	
	public Movie(int movieId, String title, String genre, String director) {
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.director =director;
	}

	public String toString() {
		return "Movie{" +
				"movieId=" + movieId +
				", title='" + title + '\'' +
				", genre='" + genre + '\'' +
				", director='" + director + '\'' +
				'}';
	}


	//
//	public String loadMovieInfo() {
//		String titleGenreDirector = title + genre + director;
//		return titleGenreDirector;
//	}
	
	
}
