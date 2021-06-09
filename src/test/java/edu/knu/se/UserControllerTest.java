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
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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

@SpringBootTest()
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

    @Before()
    public void Setup(){
        User temp1 = new User();
        temp1.setUserid("test1");
        temp1.setPasswd("passtest1");
        temp1.setId(new Long(1));
        User temp2 = new User();
        temp2.setUserid("test2");
        temp2.setPasswd("passtest2");
        temp2.setId(new Long(2));
        User temp3 = new User();
        temp3.setUserid("test3");
        temp3.setPasswd("passtest3");
        temp3.setId(new Long(3));
        User temp4 = new User();
        temp4.setUserid("test4");
        temp4.setPasswd("passtest4");
        temp4.setId(new Long(4));
    }

    @Test
    public void count_test(){

        assertEquals(4,usr.count());
    }

}
