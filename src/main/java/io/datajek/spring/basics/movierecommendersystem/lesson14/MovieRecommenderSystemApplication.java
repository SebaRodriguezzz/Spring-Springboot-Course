package io.datajek.spring.basics.movierecommendersystem.lesson14;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				"appContext.xml");

		System.out.println("\nBeans loaded:");
		System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));


		RecommenderImplementation recommender =
				appContext.getBean("recommenderImpl", RecommenderImplementation.class);


		System.out.println("\nDependency: " + recommender.getFilter());
		System.out.println();

		appContext.close();
	}

}
