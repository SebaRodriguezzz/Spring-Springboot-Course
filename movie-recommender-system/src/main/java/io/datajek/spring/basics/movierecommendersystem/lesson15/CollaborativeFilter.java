package io.datajek.spring.basics.movierecommendersystem.lesson15;

import org.springframework.stereotype.Component;

@Component("CF")
public class CollaborativeFilter implements Filter {

    public String[] getRecommendations(String movie) {
        return new String[] {};
    }

}
