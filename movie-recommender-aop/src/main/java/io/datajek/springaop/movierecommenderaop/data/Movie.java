package io.datajek.springaop.movierecommenderaop.data;

import io.datajek.springaop.movierecommenderaop.aspect.MeasureTime;
import org.springframework.stereotype.Repository;

@Repository
public class Movie {
    @MeasureTime
    public String getMovieDetails() {
        return "movie details";
    }
}