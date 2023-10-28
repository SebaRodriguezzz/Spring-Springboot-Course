package io.datajek.spring.basics.movierecommendersystem.lesson16;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode= ScopedProxyMode.TARGET_CLASS)

public class Movie {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static int instances = 0;
    private int id;
    private String name;
    private String genre;
    private String producer;

    public Movie() {
        super();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getProducer() {
        return producer;
    }
    public double movieSimilarity(Movie movie2) {

        double similarity = 0.0;
        //if genres are same add 0.3 to similarity
        //if producers are same add 0.5 to similarity
        return similarity;
    }
}


