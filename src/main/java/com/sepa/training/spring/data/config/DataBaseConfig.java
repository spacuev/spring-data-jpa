package com.sepa.training.spring.data.config;

import com.sepa.training.spring.data.entities.Country;
import com.sepa.training.spring.data.repositories.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfig {

    @Bean
    CommandLineRunner initDatabase(CountryRepository repository) {

        return args -> {
            System.out.println("Preloading " + repository.save(new Country(1L, "RUS", "Russia", "Russian Federation", "Moscow", 140000000)));
            System.out.println("Preloading " + repository.save(new Country(2L, "USA", "USA", "United States of America", "Washington", 340000000)));
            System.out.println("Preloading " + repository.save(new Country(3L, "AUS", "Australia", "Australia", "Karnberra", 40000000)));
            System.out.println("Preloading " + repository.save(new Country(4L, "GER", "Germany", "Germany", "Berlin", 60000000)));
        };
    }
}
