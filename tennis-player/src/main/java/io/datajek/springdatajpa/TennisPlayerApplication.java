package io.datajek.springdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springdata.tennisplayer.PlayerDao;

@SpringBootApplication
public class TennisPlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}

}
