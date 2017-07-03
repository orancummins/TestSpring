package com.oran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is Spring Boot main
 * The config is loaded from resources/application.properties
 *
 * tag "SpringBootApplication" is a convenience annotation that adds all of the following:
 *
 * tag "Configuration" tags the class as a source of bean definitions for the application context.
 * tag "EnableAutoConfiguration" tells Spring Boot to start adding beans based on classpath settings, other beans,
 * and various property settings. Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it
 * automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and
 * activates key behaviors such as setting up a DispatcherServlet.
 * tag "ComponentScan" tells Spring to look for other components, configurations, and services in the hello package,
 * allowing it to find the controllers.
 */
@SpringBootApplication
public class RandomNumberConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(RandomNumberConfiguration.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(RandomNumberConfiguration.class);

    /**
     * Generates an initial set of random numbers
     * @param repository
     * @return
     */
    @Bean
    public CommandLineRunner demo(RandomNumberRepository repository) {
        return (args) -> {
            // save a couple of randoms
            repository.save(new RandomNumber(LocalDateTime.now(), "Oran", "none", Math.random()));
            repository.save(new RandomNumber(LocalDateTime.now(), "Mark", "none", Math.random()));
            repository.save(new RandomNumber(LocalDateTime.now(), "Dave", "none", Math.random()));
            repository.save(new RandomNumber(LocalDateTime.now(), "Joe", "none", Math.random()));
            repository.save(new RandomNumber(LocalDateTime.now(), "Steve", "none", Math.random()));


            // fetch all randoms
            log.info("Randoms found with findAll():");
            log.info("-------------------------------");
            for (RandomNumber rn : repository.findAll()) {
                log.info(rn.toString());
            }
            log.info("");

            // fetch an individual random by ID
            RandomNumber rn1 = repository.findOne(1L);
            log.info("Random found with findOne(1L):");
            log.info("--------------------------------");
            log.info(rn1.toString());
            log.info("");

            // fetch randoms by  name
            log.info("Random found with findByName('Oran'):");
            log.info("--------------------------------------------");
            for (RandomNumber rn : repository.findByName("Oran")) {
                log.info(rn.toString());
            }
            log.info("");
        };
    }
}
