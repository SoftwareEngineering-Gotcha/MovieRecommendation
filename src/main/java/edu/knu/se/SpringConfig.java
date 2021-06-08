package edu.knu.se;


import edu.knu.se.domain.Movie;
import edu.knu.se.domain.MovieGenreScore;
import edu.knu.se.domain.Ratings;
import edu.knu.se.repository.MovieGenreScoreRepository;
import edu.knu.se.repository.MovieRepository;
import edu.knu.se.repository.RatingsRepository;
import edu.knu.se.repository.UserRepository;
import edu.knu.se.service.MovieGenreScoreService;
import edu.knu.se.service.MovieService;
import edu.knu.se.service.RatingsService;
import edu.knu.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final RatingsRepository ratingsRepository;
    private final MovieGenreScoreRepository mgs;

    @Autowired
    public SpringConfig(UserRepository userRepository, MovieRepository movieRepository
    , RatingsRepository ratingsRepository, MovieGenreScoreRepository mgs) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.ratingsRepository = ratingsRepository;
        this.mgs = mgs;
    }

    @Bean
    public MovieGenreScoreService movieGenreScoreService(){return new MovieGenreScoreService(mgs,new RatingsService(ratingsRepository),movieRepository);}

    @Bean
    public RatingsService ratingsService() {
        return new RatingsService((ratingsRepository));
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository);
    }

    @Bean
    public MovieService movieService(){
        return new MovieService(movieRepository);
    }
}
