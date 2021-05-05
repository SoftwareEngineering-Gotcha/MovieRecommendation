package edu.knu.se;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;

import java.util.ArrayList;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(final UserRepository repository){
        return args -> {
            //need to set program language level to 8
            ArrayList<Integer> arr = new ArrayList<Integer>();
            log.info("Preloading " + repository.save(new User("aaaa", "A", "1234", arr, arr)));
            log.info("Preloading " + repository.save(new User("bbbb", "A", "5678", arr, arr)));
        };
    }
}
