package io.datajek.spring.basics.movierecommendersystem.lesson6;

import org.springframework.stereotype.Component;

@Component("CBF")
public class ContentBasedFilter implements Filter {

    public String[] getRecommendations(String movie){
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }

}
