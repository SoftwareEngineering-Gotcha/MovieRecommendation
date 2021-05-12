package edu.knu.se;
import java.io.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.*;
import java.util.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository repository;
    List<String> data; 
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

    @GetMapping("/")
    List<String> return_movie(@RequestParam String uid){
    
        try {
            File csv = new File("ratings.csv");
            data = new ArrayList<String>();
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] token = line.split(",", -1);
                if(token[0].equals(uid))
                {
                    data.add(token[1]);
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        return data;
    }
    @PutMapping("/")
    String putUser(@RequestParam String uid, @RequestParam(name="passwd") String pwd) {
        String result = "FAILED";
        if(!(repository.existsById(uid))) {
            User newUser = new User();
            newUser.setUid(uid);
            newUser.setPasswd(pwd);
            repository.save(newUser);
            result = "SUCCESS";
        } else {
            repository.findById(uid)
                    .map(user -> {
                        user.setUid(uid);
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
