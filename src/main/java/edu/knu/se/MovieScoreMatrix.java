import java.util.List;

public class MovieScoreMatrix {
	private int romanceScore;
	private int actionScore;
	
	public MovieScoreMatrix(int userScore, int genreScore) {
		this.romanceScore = romanceScore;
		this.actionScore = actionScore;
	}
	
	public boolean matching(int userScore, int genreScore) {
		return userScore==genreScore;
	}
}
