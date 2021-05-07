package edu.knu.se;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<User> all(){
        return repository.findAll();
    }

    @GetMapping("/_count_")
    String count(){
        List<User> list = repository.findAll();
        return Integer.toString(list.size());
    }

    @GetMapping("/{uid}")
    User one(@PathVariable String uid){
        return repository.findById(uid)
                .orElseThrow(() -> new UserNotFoundException(uid));
    }

    @PutMapping("/")
    String putUser(@RequestParam String uid, @RequestParam String passwd) {
        String result = "FAILED";
        if(!(repository.existsById(uid))) {
            User newUser = new User();
            newUser.setUid(uid);
            newUser.setPasswd(passwd);
            repository.save(newUser);
            result = "SUCCESS";
        } else {
            repository.findById(uid)
                    .map(user -> {
                        user.setUid(uid);
                        user.setPasswd(passwd);
                        repository.save(user);
                        return "";
                    });
            result = "SUCCESS";
        }
        return "{\"result\":" + result + "\"}";
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
