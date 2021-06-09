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

    @Before
    void init(){
        User temp = new User();
        temp.setUserid("Test1");
        temp.setPasswd("1111");
        userService.join(temp);
        temp.setUserid("Test2");
        temp.setPasswd("1111");
        userService.join(temp);
        temp.setUserid("Test3");
        temp.setPasswd("1111");
        userService.join(temp);
        temp.setUserid("Test4");
        temp.setPasswd("1111");
        userService.join(temp);

    }

    @Test
    void count_test(){
        assertEquals(4,usr.count());
    }

    @Test
    void all_test(){
        boolean result = false;
        
        assertTrue();
    }


}
*/