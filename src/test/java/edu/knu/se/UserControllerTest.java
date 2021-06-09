package edu.knu.se;

import static org.junit.Assert.*;

import edu.knu.se.controller.UserController;
import edu.knu.se.domain.Movie;
import edu.knu.se.domain.User;
import edu.knu.se.repository.UserRepository;
import edu.knu.se.service.MovieService;
import edu.knu.se.service.RatingsService;
import edu.knu.se.service.UserService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
/*
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("...")
@AutoConfigureTestDatabase()
public class UserControllerTest {

    @Autowired
    UserService userService;

    @Autowired
    MovieService movieService;

    @Autowired
    RatingsService ratingsService;

    @Autowired
    UserController usr = new UserController(userService, movieService, ratingsService);

    @


}
*/