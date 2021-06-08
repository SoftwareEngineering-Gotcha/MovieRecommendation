package edu.knu.se.service;

import edu.knu.se.domain.Movie;
import edu.knu.se.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {this.movieRepository = movieRepository;}

    public long join(Movie movie){


        movieRepository.save(movie);
        return movie.getMovieid();
    }



    public List<Movie> findMember(){return movieRepository.findAll();}
    public List<Movie> findAll(){return movieRepository.findAll();}
    public Optional<Movie> findOne(Long movieid){return movieRepository.findById(movieid);}
    public boolean ExistsById(Long movieid) {return movieRepository.existsById(movieid);}
    public void deleteById(Long Id){movieRepository.deleteById(Id);}
}
