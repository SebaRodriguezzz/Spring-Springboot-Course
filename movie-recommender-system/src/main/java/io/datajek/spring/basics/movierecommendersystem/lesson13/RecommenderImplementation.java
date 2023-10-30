package io.datajek.spring.basics.movierecommendersystem.lesson13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    private Filter filter;

    @Autowired
    public RecommenderImplementation(Filter filter) {
        this.filter = filter;
        System.out.println("Constructor invoked...");
    }

    public String[] recommendMovies(String movie){
        System.out.println("Name of the filter in use: " + filter);
        String[] results = filter.getRecommendations(movie);
        return results;
    }

}
