package edu.knu.se.service;


import edu.knu.se.domain.Movie;
import edu.knu.se.domain.MovieGenreScore;
import edu.knu.se.domain.Ratings;
import edu.knu.se.repository.MovieGenreScoreRepository;
import edu.knu.se.repository.MovieRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
public class MovieGenreScoreService {
    private final MovieGenreScoreRepository mgsrepository;
    private final RatingsService ratingsService;
    private final MovieRepository movieService;
    public MovieGenreScoreService(MovieGenreScoreRepository mgsrepository, RatingsService ratingsService, MovieRepository movieService) {
        this.mgsrepository = mgsrepository;
        this.ratingsService = ratingsService;
        this.movieService = movieService;
    }

    public long save(MovieGenreScore mgs){

        mgsrepository.save(mgs);
        return mgs.getUserid();
    }

    public MovieGenreScore getscorebyrating(Long userid){
        List<Ratings> list = ratingsService.findByUserid(userid);
        MovieGenreScore mgs = new MovieGenreScore();
        for(int i = 0; i < list.size(); i++)
        {
           Ratings ratings = list.get(i);
           Optional<Movie> movie = movieService.findById(ratings.getMovieid());
           String fortoken = movie.get().getGenres();
           String[] token = fortoken.split("\\|",-1);

           for(int k = 0; k < token.length; k++){

               if(token[k].equals("Action")){
                   Float temp = mgs.getAction();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setAction(temp+ratings.getRating()/2);
                   continue;
               }

               else
               {
                   Float temp = mgs.getAction();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setAction(temp + new Float(0.0));

               }
               if(token[k].equals("Adventure")){
                   Float temp = mgs.getAdventure();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setAdventure(temp + ratings.getRating()/2);
                   continue;
               }
               else
               {
                   Float temp = mgs.getAdventure();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setAdventure(temp + new Float(0.0));
               }
               if(token[k].equals("Animation")){
                   Float temp = mgs.getAnimation();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setAnimation(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getAnimation();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setAnimation(temp + new Float(0.0));
               }
               if(token[k].equals("Children's")){
                   Float temp = mgs.getChildren();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setChildren(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getChildren();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setChildren(temp + new Float(0.0));
               }
               if(token[k].equals("Comedy")){
                   Float temp = mgs.getComedy();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setComedy(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getComedy();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setComedy(temp + new Float(0.0));
               }
               if(token[k].equals("Crime")){
                   Float temp = mgs.getCrime();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setCrime(temp +ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getCrime();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setCrime(temp + new Float(0.0));
               }
               if(token[k].equals("Documentary")){
                   Float temp = mgs.getDocumentary();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setDocumentary(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getDocumentary();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setDocumentary(temp + new Float(0.0));
               }
               if(token[k].equals("Drama")){
                   Float temp = mgs.getDrama();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setDrama(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getDrama();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setDrama(temp + new Float(0.0));
               }
               if(token[k].equals("Fantasy")){
                   Float temp = mgs.getFantasy();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setFantasy(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getFantasy();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setFantasy(temp + new Float(0.0));
               }
               if(token[k].equals("Film-Noir")){
                   Float temp = mgs.getFilmNoir();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setFilmNoir(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getFilmNoir();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setFilmNoir(temp + new Float(0.0));
               }
               if(token[k].equals("Horror")){
                   Float temp = mgs.getHorror();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setHorror(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getHorror();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setHorror(temp + new Float(0.0));
               }
               if(token[k].equals("Musical")){
                   Float temp = mgs.getMusical();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setMusical(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getMusical();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setMusical(temp + new Float(0.0));
               }
               if(token[k].equals("Mystery")){
                   Float temp = mgs.getMystery();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setMystery(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getMystery();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setMystery(temp + new Float(0.0));
               }
               if(token[k].equals("Romance")){
                   Float temp = mgs.getRomance();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setRomance(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getRomance();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setRomance(temp + new Float(0.0));
               }
               if(token[k].equals("Sci-Fi")){
                   Float temp = mgs.getScifi();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setScifi(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getScifi();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setScifi(temp + new Float(0.0));
               }
               if(token[k].equals("Thriller")){
                   Float temp = mgs.getThriller();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setThriller(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getThriller();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setThriller(temp + new Float(0.0));
               }
               if(token[k].equals("War")){
                   Float temp = mgs.getWar();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setWar(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getThriller();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setWar(temp + new Float(0.0));
               }
               if(token[k].equals("Western")){
                   Float temp = mgs.getWestern();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setWestern(temp + ratings.getRating()/2);continue;
               }
               else
               {
                   Float temp = mgs.getWestern();
                   if(temp == null)
                   {
                       temp = new Float(0.0);
                   }
                   mgs.setWestern(temp + new Float(0.0));
               }


           }


        }
        mgs.setUserid(userid);
        if(mgsrepository.existsByUserid(userid)) {
            Long tempid = mgsrepository.findByUserid(userid).get().getId();
            /*
            mgsrepository.update_set(mgsrepository.findByUserid(userid).get().getId(),mgs.getUserid(),mgs.getAction(),
                    mgs.getAnimation(),mgs.getAdventure(),mgs.getChildren(),mgs.getComedy(),mgs.getCrime(),mgs.getDocumentary(),
                    mgs.getDrama(),mgs.getFantasy(),mgs.getFilmNoir(),mgs.getHorror(),mgs.getMusical(),mgs.getMystery(),mgs.getRomance(),
                    mgs.getScifi(),mgs.getThriller(),mgs.getWar(),mgs.getWestern());*/
            mgsrepository.save(mgs);
            mgsrepository.deleteById(tempid);
        }
        else {
            mgsrepository.save(mgs);
        }
        return mgs;
    }

    public List<Movie> getRecommendedMovieList(Long userid) {
        MovieGenreScore mgs = mgsrepository.findByUserid(userid).get();
        HashMap<Movie, Float> hm = new HashMap<Movie, Float>();
        List<Movie> list = new ArrayList<Movie>(30);
        List<Movie> data = movieService.findAll();
        for (int i = 0; i < data.size(); i++) {
            String st1 = data.get(i).getGenres();
            String[] token = st1.split("\\|", -1);
            Float temp_data = new Float(0.0);
            for (int k = 0; k < token.length; k++) {

                if (token[k].equals("Action")) {
                    Float temp = mgs.getAction();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getAction();
                }

                if (token[k].equals("Adventure")) {
                    Float temp = mgs.getAdventure();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getAdventure();

                }

                if (token[k].equals("Animation")) {
                    Float temp = mgs.getAnimation();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getAnimation();
                }

                if (token[k].equals("Children's")) {
                    Float temp = mgs.getChildren();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getChildren();
                }

                if (token[k].equals("Comedy")) {
                    Float temp = mgs.getComedy();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getComedy();
                }

                if (token[k].equals("Crime")) {
                    Float temp = mgs.getCrime();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getCrime();
                }

                if (token[k].equals("Documentary")) {
                    Float temp = mgs.getDocumentary();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getDocumentary();
                }

                if (token[k].equals("Drama")) {
                    Float temp = mgs.getDrama();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getDrama();
                }

                if (token[k].equals("Fantasy")) {
                    Float temp = mgs.getFantasy();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getFantasy();
                } else if (token[k].equals("Film-Noir")) {
                    Float temp = mgs.getFilmNoir();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getFilmNoir();
                }

                if (token[k].equals("Horror")) {
                    Float temp = mgs.getHorror();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getHorror();
                }

                if (token[k].equals("Musical")) {
                    Float temp = mgs.getMusical();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getMusical();
                }

                if (token[k].equals("Mystery")) {
                    Float temp = mgs.getMystery();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getMystery();
                }

                if (token[k].equals("Romance")) {
                    Float temp = mgs.getRomance();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getRomance();
                }

                if (token[k].equals("Sci-Fi")) {
                    Float temp = mgs.getScifi();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getScifi();
                }

                if (token[k].equals("Thriller")) {
                    Float temp = mgs.getThriller();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getThriller();
                }

                if (token[k].equals("War")) {
                    Float temp = mgs.getWar();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getWar();
                }

                if (token[k].equals("Western")) {
                    Float temp = mgs.getWestern();
                    if (temp == null) {
                        temp = new Float(0.0);
                    }
                    temp_data += temp * mgs.getWestern();
                }

            }
            if(list.size() <= 30){
                System.out.println("list진입성공");
                list.add(data.get(i));
                hm.put(data.get(i),temp_data);
            }else
            {
                System.out.print("else문");
                for(int l = 0; l < 30; l++)
                {

                    if(hm.get(data.get(l)) != null)
                    if(hm.get(data.get(l)) <= temp_data){
                        System.out.println("역전!");
                        hm.remove(data.get(l));
                        hm.put(data.get(i),temp_data);
                        list.remove(l);
                        list.add(data.get(i));
                        break;
                    }
                }
                System.out.println("끝");
            }
        }
        return list;
    }
}
