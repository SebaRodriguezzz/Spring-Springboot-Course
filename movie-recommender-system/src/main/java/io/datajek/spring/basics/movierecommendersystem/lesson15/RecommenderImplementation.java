package io.datajek.spring.basics.movierecommendersystem.lesson15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    @Autowired
    @Qualifier("CF")
    private Filter filter;

    @Value("${recommender.implementation.favoriteMovie: Finding Dory}")
    public String favoriteMovie;

    public String getFavoriteMovie() {
        return favoriteMovie;
    }
    public String[] recommendMovies(String movie){
        System.out.println("Name of the filter in use: " + filter);
        String[] results = filter.getRecommendations(movie);
        return results;
    }

}
