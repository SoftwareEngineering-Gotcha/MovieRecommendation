package edu.knu.se;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository repository;

    UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("")
    List<User> all(){
        return repository.findAll();
    }

    @GetMapping("/_count_")
    int count(){
        List<User> list = repository.findAll();
        return list.size();
    }

    @PutMapping("/")
    String putUser(@RequestParam String uid, @RequestParam(name="passwd") String pwd) {
        String result = "FAILED";
        if(!(repository.existsById(uid))) {
            User newUser = new User();
            newUser.setId(uid);
            newUser.setPasswd(pwd);
            repository.save(newUser);
            result = "SUCCESS";
        } else {
            repository.findById(uid)
                    .map(user -> {
                        user.setId(uid);
                        user.setPasswd(pwd);
                        repository.save(user);
                        return "";
                    });
            result = "SUCCESS";
        }
        return "{\"result\":"+result+"\"}";
    }

    @DeleteMapping("/")
    String deleteUid(@RequestParam String uid) {
        String result = "FAILED";
        if((repository.existsById(uid))) {
            repository.deleteById(uid);
            result = "SUCCESS";
        }
        return "{\"result\":\"" + result + "\"}";
    }
}
