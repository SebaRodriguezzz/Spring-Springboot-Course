package io.datajek.spring.basics.movierecommendersystem.lesson13;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("CBF")
public class ContentBasedFilter implements Filter {

    public String[] getRecommendations(String movie){
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }

}
