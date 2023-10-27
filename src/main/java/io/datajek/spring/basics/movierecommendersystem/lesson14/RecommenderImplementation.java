package io.datajek.spring.basics.movierecommendersystem.lesson14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    @Autowired
    @Qualifier("contentBasedFilter")
    private Filter filter;

    public Filter getFilter() {
        return filter;
    }
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public String[] recommendMovies(String movie){
        System.out.println("Name of the filter in use: " + filter);
        String[] results = filter.getRecommendations(movie);
        return results;
    }


}
