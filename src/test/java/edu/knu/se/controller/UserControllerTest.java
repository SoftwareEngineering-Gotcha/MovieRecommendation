package edu.knu.se.controller;

import static org.junit.Assert.*;

import edu.knu.se.controller.UserController;
import edu.knu.se.domain.Movie;
import edu.knu.se.domain.User;
import edu.knu.se.repository.UserRepository;
import edu.knu.se.service.MovieService;
import edu.knu.se.service.RatingsService;
import edu.knu.se.service.UserService;
import org.junit.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;


@RunWith(SpringRunner.class)

@SpringBootTest
@Transactional
public class UserControllerTest {

    @Autowired
    private UserService userService;
    @Autowired
    private RatingsService ratingsService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private UserController usr = new UserController(userService, movieService, ratingsService);

    @Autowired
    private UserRepository userRepository;


    Integer temp_count;

    @Before()
    public void Setup(){
        User temp1 = new User();
        User temp2 = new User();
        temp_count = usr.count();
        temp1.setUserid("test");
        temp1.setPasswd("test");
        userRepository.save(temp1);
        temp2.setUserid("test2");
        temp2.setPasswd("test2");
        userRepository.save(temp2);
    }

    @Test
    public void count_test(){
        assertEquals(temp_count + 2,usr.count());
    }

}
