package io.datajek.spring.basics.movierecommendersystem.lesson15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

@SpringBootApplication
@PropertySource("classpath:app.properties")
public class MovieRecommenderSystemApplication {
	public static void main(String[] args) {

		ApplicationContext appContext = SpringApplication.run(
		MovieRecommenderSystemApplication.class, args);

		RecommenderImplementation recommender = appContext.getBean
				(RecommenderImplementation.class);

		String favoriteMovie = recommender.getFavoriteMovie();
		System.out.println(favoriteMovie);
	}
}