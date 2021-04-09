public class Movie {
	private String title;
	private String genre;
	private String director;
	
	public Movie(String title, String genre, String director) {
		this.title = title;
		this.genre = genre;
		this.director =director;
	}
	
	public String loadMovieInfo() {
		String titleGenreDirector = title + genre + director;
		return titleGenreDirector;
	}
	
	
}
