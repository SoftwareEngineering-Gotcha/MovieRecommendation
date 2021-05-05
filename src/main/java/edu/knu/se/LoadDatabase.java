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
            ArrayList<Integer> arr = new ArrayList<Integer>();
            log.info("Preloading " + repository.save(new User("aaaa", "aaaa", "qwer1234", arr, arr)));
            log.info("Preloading " + repository.save(new User("bbbb", "bbbb", "asdf1234", arr, arr)));
        };
    }
}
