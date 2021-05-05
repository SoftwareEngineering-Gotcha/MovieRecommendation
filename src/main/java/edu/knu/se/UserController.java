package edu.knu.se;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository repository;

    UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all(){
        return repository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser){
        return repository.save(newUser);
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable String id){
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable String id){
        return repository.findById(id)
                .map(user -> {
                    user.setId(newUser.getId());
                    user.setPasswd(newUser.getPasswd());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable String id){
        repository.deleteById(id);
    }
}